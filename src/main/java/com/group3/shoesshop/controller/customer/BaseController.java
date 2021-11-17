package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.service.IBrandService;
import com.group3.shoesshop.service.ICategoryService;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public abstract class BaseController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private IUserService userService;

    protected ModelAndView returnModelAndView(HttpServletRequest request, ModelAndView mav) {
        // fake data to test
        request.getSession().setAttribute(Constant.USER_SESSION, userService.findOne(6));

        mav.addObject("brands", brandService.findAll());
        mav.addObject("categories", categoryService.findAll());
        mav.addObject("userSession", request.getSession().getAttribute(Constant.USER_SESSION));
        return mav;
    }
}
