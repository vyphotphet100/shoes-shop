package com.group3.shoesshop.controller.common;

import com.group3.shoesshop.constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {
    @GetMapping(value = "/")
    public ModelAndView root(HttpServletRequest request) {
        return new ModelAndView("Customer_Page/Pages/Homepage/root");
    }

    @GetMapping(value = "/home")
    public ModelAndView home(HttpServletRequest request, @RequestParam(required = false) String rootPath) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/Homepage/index");
        if (rootPath != null)
            Constant.ROOT_PATH = rootPath;

        return returnModelAndView(request, mav);
    }
}
