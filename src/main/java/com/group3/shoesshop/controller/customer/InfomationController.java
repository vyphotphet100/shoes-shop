package com.group3.shoesshop.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfomationController {
    @GetMapping(value = "/customer/information/about-us")
    public ModelAndView aboutUs() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/AboutUs/index");

        return mav;
    }

    @GetMapping(value = "/customer/information/contact-us")
    public ModelAndView contactUs() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/ContactUs/index");

        return mav;
    }

    @GetMapping(value = "/customer/information/privacy-policy")
    public ModelAndView privacyPolicy() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/PrivacyPolicy/index");

        return mav;
    }
    @GetMapping(value = "/customer/information/tearm-and-conditions")
    public ModelAndView teamAndConditions() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/TearmAndConditions/index");

        return mav;
    }
}
