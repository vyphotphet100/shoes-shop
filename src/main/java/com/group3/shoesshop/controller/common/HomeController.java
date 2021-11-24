package com.group3.shoesshop.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {
    @GetMapping(value = "/")
    public ModelAndView root(HttpServletRequest request) {
        return this.home(request);
    }

    @GetMapping(value = "/home")
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/Homepage/index");

        return returnModelAndView(request, mav);
    }
}
