package com.group3.shoesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@Controller
public class MainController extends HttpServlet {

    @GetMapping(value = "/test")
    public ModelAndView test() throws Exception {
        // a
        ModelAndView modelAndView = new ModelAndView("test");
        //MyUtils.getFileFromGoogleCloud();
        return modelAndView;
    }


}
