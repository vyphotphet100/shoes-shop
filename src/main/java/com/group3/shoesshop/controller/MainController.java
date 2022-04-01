package com.group3.shoesshop.controller;

import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class MainController extends HttpServlet {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private IProductService productService;

    @Autowired
    private EntityManager entityManager;


    @GetMapping(value = "/test")
    public ModelAndView test() throws Exception {
        Pageable pageable = PageRequest.of(1, 5);

        productService.findAll(pageable, null, null, null, null, null, true);

        return null;
    }


}
