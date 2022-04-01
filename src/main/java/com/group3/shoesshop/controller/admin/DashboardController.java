package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "dashboard-admin")
public class DashboardController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private IPaymentService paymentService;

    @GetMapping(value = "/admin/dashboard")
    public ModelAndView dashboard() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/DashBoard/index");

        mav.addObject("totalCost", orderItemService.getTotalCostOfOrdered());
        mav.addObject("averageCost", orderItemService.getAverageCost());
        mav.addObject("totalOrdered", orderItemService.getTotalOrdered());

        mav.addObject("totalProductQuantity", productService.getSumOfQuantity(true));
        mav.addObject("totalCategory", categoryService.findAll().size());
        mav.addObject("totalBrand", brandService.findAll().size());

        mav.addObject("totalPayment", paymentService.findAll().size());
        mav.addObject("totalCustomer", userService.findAllBuyerByIsActive(true).size());
        mav.addObject("totalSeller", userService.findAllSellerByIsActive(true).size());

        return mav;
    }

}
