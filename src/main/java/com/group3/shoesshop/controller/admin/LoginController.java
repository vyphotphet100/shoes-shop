package com.group3.shoesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping(value = "/admin/login")
    public ModelAndView loginGet() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Login/index");

        return mav;
    }
}
