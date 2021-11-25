package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.converter.dto_entity.mapper.OrderItemMapper;
import com.group3.shoesshop.dto.OrderItemDTO;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IOrderItemService;
import com.group3.shoesshop.service.IPaymentMethodService;
import com.group3.shoesshop.service.IUserService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
        for (Object id: orderItemEntity.getListRequest()){
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
        ////

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

    @GetMapping(value = "/customer/paying/thanks")
    public ModelAndView thanks(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/Thanks/index");

        return returnModelAndView(request, mav);
    }
}
