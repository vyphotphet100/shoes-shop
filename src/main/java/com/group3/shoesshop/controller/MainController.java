package com.group3.shoesshop.controller;

import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class MainController extends HttpServlet {

    @Autowired
    private UserRepository userRepo;

    @GetMapping(value = "/test")
    public ModelAndView test() throws Exception {
        ModelAndView modelAndView = new ModelAndView("test");


        List<UserEntity> userEntities = userRepo.findAllBuyerByKeyword("5");


        return modelAndView;
    }


}
