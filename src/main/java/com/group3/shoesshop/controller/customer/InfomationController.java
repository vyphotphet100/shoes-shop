package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InfomationController extends BaseController {
    @GetMapping(value = "/customer/information/about-us")
    public ModelAndView aboutUs(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/AboutUs/index");

        return returnModelAndView(request, mav);
    }

    @GetMapping(value = "/customer/information/contact-us")
    public ModelAndView contactUs(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/ContactUs/index");

        return returnModelAndView(request, mav);
    }

    @GetMapping(value = "/customer/information/privacy-policy")
    public ModelAndView privacyPolicy(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/PrivacyPolicy/index");

        return returnModelAndView(request, mav);
    }
    @GetMapping(value = "/customer/information/term-and-conditions")
    public ModelAndView teamAndConditions(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/TearmAndConditions/index");

        return returnModelAndView(request, mav);
    }

    @GetMapping(value = "/customer/information/sitemap")
    public ModelAndView siteMap(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Information/SiteMap/index");

        return returnModelAndView(request, mav);
    }
}
