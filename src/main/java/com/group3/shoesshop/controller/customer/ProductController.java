package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/customer/product/product-list")
    public ModelAndView productList() {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/ProductPage/index");
        mav.addObject("products", productService.findAll());
        return mav;
    }
    @GetMapping(value = "/customer/product/product-detail")
    public ModelAndView ProductDetail() {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/ProductDetailPage/index");

        return mav;
    }
}
