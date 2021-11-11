package com.group3.shoesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {

    @GetMapping(value = "/admin/seller/add")
    public ModelAndView addSellerGet() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Seller/AddSeller/index");
        return mav;
    }

    @GetMapping(value = "/admin/seller/seller-list")
    public ModelAndView sellerList() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Seller/SellerList/index");
        return mav;
    }

}
