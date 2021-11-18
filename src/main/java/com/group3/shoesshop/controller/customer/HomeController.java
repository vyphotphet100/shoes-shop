package com.group3.shoesshop.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping(value = "/customer/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Homepage/index");

        return mav;
    }
}
