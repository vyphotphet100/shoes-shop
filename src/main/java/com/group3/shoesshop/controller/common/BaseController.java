package com.group3.shoesshop.controller.common;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.entity.BrandEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IBrandService;
import com.group3.shoesshop.service.ICategoryService;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        //request.getSession().setAttribute(Constant.USER_SESSION, userService.findOne(6));

        long start1 = System.nanoTime();

        mav.addObject("brands", brandService.findAll());
        mav.addObject("categories", categoryService.findAll());

        mav.addObject("userSession", request.getSession().getAttribute(Constant.USER_SESSION));
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute(Constant.USER_SESSION);

        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
        return mav;
    }
}