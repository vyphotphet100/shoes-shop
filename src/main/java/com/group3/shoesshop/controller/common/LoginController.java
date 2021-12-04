package com.group3.shoesshop.controller.common;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/login")
    public ModelAndView loginGet(UserEntity user) {
//        ModelAndView mav = new ModelAndView("Common_Page/Login/index");
//        if (user == null)
//            mav.addObject("user", new UserEntity());
//        else
//            mav.addObject("user", user);
//        return mav;
        return new ModelAndView("redirect:/customer/my-account/login");
    }

    @PostMapping(value = "/login")
    public ModelAndView loginPost(@ModelAttribute UserEntity user, HttpServletRequest request) {
        UserEntity userEntity = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (!userEntity.getHttpStatus().equals(HttpStatus.OK))
            return this.loginGet(userEntity);

        request.getSession().setAttribute(Constant.USER_SESSION, userEntity);
        if (userEntity.getRole().getCode().equals(Constant.ROLE_ADMIN))
            return new ModelAndView("redirect:/admin/customer/customer-list");
        else if (userEntity.getRole().getCode().equals(Constant.ROLE_SELLER))
            return new ModelAndView("redirect:/seller/dashboard");
        else
            return new ModelAndView("redirect:/customer/dashboard");
    }

    @GetMapping(value = "/before-logout")
    @ResponseBody
    public String logOut(HttpServletRequest request) {
        request.getSession().setAttribute(Constant.USER_SESSION, null);
        return "<script>" +
                "var url = new URL(window.location.href);" +
                "if (url.searchParams.get('message') != null)" +
                "alert(url.searchParams.get('message'));" +
                "window.location.href = '/customer/my-account/login';" +
                "</script>";
    }
}
