package com.group3.shoesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @GetMapping(value = "/admin/order/order-detail")
    public ModelAndView orderDetail() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Order/OrderDetail/index");
        return mav;
    }

    @GetMapping(value = "/admin/order/order-list")
    public ModelAndView orderList() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Order/OrderList/index");
        return mav;
    }

}
