package com.group3.shoesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/test")
public class MainController extends HttpServlet {

    @GetMapping
    public ModelAndView test() {
        // a
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

}
