package com.group3.shoesshop.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PayingController {

    @GetMapping(value = "/customer/paying/shopping-cart")
    public ModelAndView shoppingCart() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/ShoppingCart/index");

        return mav;
    }

    @GetMapping(value = "/customer/paying/checkout")
    public ModelAndView checkOut() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/CheckOut/index");

        return mav;
    }
}
