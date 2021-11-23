package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IOrderItemService;
import com.group3.shoesshop.service.IPaymentMethodService;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckOutController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPaymentMethodService paymentMethodService;

    @Autowired
    private IOrderItemService orderItemService;

    @GetMapping(value = "/customer/check-out")
    public ModelAndView checkOut(HttpServletRequest request) {
        // fake data
        List<OrderItemEntity> readyOrderItemsTmp = new ArrayList<>();
        readyOrderItemsTmp.add(orderItemService.findOne(1));
        readyOrderItemsTmp.add(orderItemService.findOne(2));
        readyOrderItemsTmp.add(orderItemService.findOne(3));
        request.getSession().setAttribute(Constant.READY_ORDER_ITEMS, readyOrderItemsTmp);
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

}