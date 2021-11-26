package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.converter.dto_entity.mapper.OrderItemMapper;
import com.group3.shoesshop.dto.OrderItemDTO;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.PaymentEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.*;
import com.group3.shoesshop.utils.MyUtils;
import com.group3.shoesshop.utils.PaymentUtils;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PayingController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private DTOEntityConverter converter;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private IPaymentMethodService paymentMethodService;

    @Autowired
    private IPayPalService payPalService;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private IVNPAYService VNPAYService;

    @GetMapping(value = "/customer/paying/shopping-cart")
    public ModelAndView shoppingCart(HttpServletRequest request) {
        UserEntity userEntity = MyUtils.getUserFromSession(request);
        if (userEntity == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/ShoppingCart/index");
        List<OrderItemEntity> orderItems = userService.getOrderItemsWithoutPayment(userEntity.getId());
        mav.addObject("orderItems", orderItems);
        return returnModelAndView(request, mav);
    }

    @GetMapping(value = "/customer/paying/shopping-cart/get-order-item")
    public ResponseEntity<OrderItemDTO> getOrderItem(@RequestParam(required = true) Integer id) {

        OrderItemEntity orderItemEntity = orderItemService.findOne(id);
        OrderItemDTO orderItemDto = converter.toDTO(orderItemEntity, orderItemMapper);
        return new ResponseEntity<OrderItemDTO>(orderItemDto, orderItemDto.getHttpStatus());
    }

    @DeleteMapping(value = "/customer/paying/shopping-cart/delete-order-item")
    public void deleteOrderItem(@RequestParam(required = true) Integer id) {

        orderItemService.delete(id);
    }

    @PutMapping(value = "/customer/paying/shopping-cart/update-quantity")
    public ResponseEntity<OrderItemDTO> shoppingCartUpdateQuantity(@RequestBody OrderItemEntity orderItemEntity) {
        if (orderItemEntity == null)
            return null;

        orderItemEntity = orderItemService.updateQuantityBought(orderItemEntity.getId(), orderItemEntity.getQuantityBought());
        OrderItemDTO orderItemDto = converter.toDTO(orderItemEntity, orderItemMapper);
        return new ResponseEntity<OrderItemDTO>(orderItemDto, orderItemDto.getHttpStatus());
    }

    @PostMapping(value = "/customer/paying/add-ready-order-item")
    public void addReadyOrderItem(@RequestBody OrderItemEntity orderItemEntity, HttpServletRequest request) {
        List<OrderItemEntity> readyOrderItems = new ArrayList<>();
        for (Object id : orderItemEntity.getListRequest()) {
            OrderItemEntity orderItem = orderItemService.findOne((Integer) id);
            readyOrderItems.add(orderItem);
        }

        request.getSession().setAttribute(Constant.READY_ORDER_ITEMS, readyOrderItems);
    }

    @GetMapping(value = "/customer/paying/checkout")
    public ModelAndView checkOut(HttpServletRequest request) {
        // fake data
//        List<OrderItemEntity> readyOrderItemsTmp = new ArrayList<>();
//        readyOrderItemsTmp.add(orderItemService.findOne(1));
//        readyOrderItemsTmp.add(orderItemService.findOne(2));
//        readyOrderItemsTmp.add(orderItemService.findOne(3));
//        request.getSession().setAttribute(Constant.READY_ORDER_ITEMS, readyOrderItemsTmp);

        ModelAndView mav = new ModelAndView("Customer_Page/Pages/CheckOut/index");

        List<OrderItemEntity> readyOrderItems = (List<OrderItemEntity>) request.getSession().getAttribute(Constant.READY_ORDER_ITEMS);
        if (readyOrderItems == null)
            return null;

        mav.addObject("customer", new UserEntity());
        mav.addObject("paymentMethods", paymentMethodService.findAll());
        mav.addObject("readyOrderItems", readyOrderItems);
        mav.addObject("total", orderItemService.getTotalCostOfOrderItemList(readyOrderItems));

        return this.returnModelAndView(request, mav);
    }

    @PostMapping(value = "/customer/paying/pay")
    public ResponseEntity<OrderItemDTO> pay(HttpServletRequest request) throws PayPalRESTException {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        OrderItemDTO orderItemDto = new OrderItemDTO();
        if (userSession == null) {
            orderItemDto.getListResult().add("/customer/my-account/login");
            return new ResponseEntity<OrderItemDTO>(orderItemDto, orderItemDto.getHttpStatus());
        }

        List<OrderItemEntity> readyOrderItems = (List<OrderItemEntity>) request.getSession().getAttribute(Constant.READY_ORDER_ITEMS);

        String redirectLink = null;
        if (userSession.getPaymentMethod().getId().equals(1)) // PayPal
            redirectLink = payPalService.authorizePayment(readyOrderItems);
        else if (userSession.getPaymentMethod().getId().equals(2) ||
                userSession.getPaymentMethod().getId().equals(3)) // VNPAY/COD
            redirectLink = "/customer/paying/review-payment";

        orderItemDto.getListResult().add(redirectLink);
        return new ResponseEntity<OrderItemDTO>(orderItemDto, orderItemDto.getHttpStatus());
    }

    @GetMapping(value = "/customer/paying/review-payment")
    public ModelAndView reviewPayment(HttpServletRequest request,
                                      @RequestParam(required = false) String paymentId,
                                      @RequestParam(required = false) String PayerID) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        ModelAndView mav = null;
        List<OrderItemEntity> readyOrderItems = (List<OrderItemEntity>) request.getSession().getAttribute(Constant.READY_ORDER_ITEMS);

        if (userSession.getPaymentMethod().getId().equals(1)) { // PayPal
            mav = new ModelAndView("Customer_Page/Pages/ReviewPayment/index");
            mav.addObject("readyOrderItems", readyOrderItems);
            if (paymentId == null || PayerID == null)
                return new ModelAndView("redirect:/customer/my-account/login");

            try {
                Payment payment = payPalService.getPaymentDetails(paymentId);

                PayerInfo payerInfo = payment.getPayer().getPayerInfo();
                Transaction transaction = payment.getTransactions().get(0);

                mav.addObject("payer", payerInfo);
                mav.addObject("transaction", transaction);

                return returnModelAndView(request, mav);

            } catch (PayPalRESTException ex) {
                ex.printStackTrace();
            }
        } else if (userSession.getPaymentMethod().getId().equals(2) ||
                userSession.getPaymentMethod().getId().equals(3)) { // VNPAY/COD
            mav = new ModelAndView("Customer_Page/Pages/ReviewPayment/VNPAY/index");
            mav.addObject("readyOrderItems", readyOrderItems);
            String description = PaymentUtils.generateDescriptionFromOrderItemList(readyOrderItems);
            float total = PaymentUtils.getTotalCostOfOrderItemList(readyOrderItems);
            mav.addObject("exchangeRate", Constant.EXCHANGE_RATE_USD_VND);
            mav.addObject("description", description);
            mav.addObject("total", total);
            return returnModelAndView(request, mav);
        }


        return returnModelAndView(request, mav);
    }

    @PostMapping(value = "/customer/paying/execute-payment")
    public ModelAndView executePayment(HttpServletRequest request,
                                       @RequestParam(required = false) String paymentId,
                                       @RequestParam(required = false) String PayerID,
                                       @RequestParam(required = false) String vnp_PayDate) {

        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        List<OrderItemEntity> readyOrderItems = (List<OrderItemEntity>) request.getSession().getAttribute(Constant.READY_ORDER_ITEMS);
        if (readyOrderItems == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        if (userSession.getPaymentMethod().getId().equals(1)) { // PayPal
            try {
                if (paymentId == null || PayerID == null)
                    return new ModelAndView("redirect:/customer/my-account/login");

                Payment payment = payPalService.executePayment(paymentId, PayerID);

//            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
//            Transaction transaction = payment.getTransactions().get(0);

            } catch (PayPalRESTException ex) {
                ex.printStackTrace();
                return null;
            }
        } else if (userSession.getPaymentMethod().getId().equals(2)) { // VNPAY
            try {
                if (vnp_PayDate == null) {
                    String redirectLink = VNPAYService.getRedirectLink(request, readyOrderItems);
                    return new ModelAndView("redirect:" + redirectLink);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }

        // save payment
        for (OrderItemEntity orderItemEntity : readyOrderItems) {
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setOrderItem(orderItemEntity);
            paymentEntity.setPaymentDate(new Date());
            paymentService.save(paymentEntity);
        }
        return new ModelAndView("redirect:/customer/paying/thanks");
    }

    @GetMapping(value = "/customer/paying/execute-payment")
    public ModelAndView executePaymentGet(HttpServletRequest request,
                                          @RequestParam(required = false) String paymentId,
                                          @RequestParam(required = false) String PayerID,
                                          @RequestParam(required = false) String vnp_PayDate) {
        return this.executePayment(request, paymentId, PayerID, vnp_PayDate);
    }

    @PutMapping(value = "/customer/paying/update-user-before-paying")
    public void updateUserBeforePaying(HttpServletRequest request, @RequestBody UserEntity user) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return;

        String phone = (String) user.getListRequest().get(0);
        String address = (String) user.getListRequest().get(1);
        Integer paymentMethodId = (Integer) user.getListRequest().get(2);

        user.setId(userSession.getId());
        user.setPhone(phone);
        user.setAddress(address);
        user.setPaymentMethod(paymentMethodService.findOne(paymentMethodId));
        user = userService.update(user);
        request.getSession().setAttribute(Constant.USER_SESSION, user);
    }

    @GetMapping(value = "/customer/paying/thanks")
    public ModelAndView thanks(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/Thanks/index");

        return returnModelAndView(request, mav);
    }
}
