package com.group3.shoesshop.controller.seller;

import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.*;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
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

    @GetMapping(value = "/seller/dashboard")
    public ModelAndView dashboard(HttpServletRequest request) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        ModelAndView mav = new ModelAndView("Seller_Page/Pages/DashBoard/index");

        mav.addObject("totalCost", orderItemService.getTotalCostOfOrderedBySellerId(userSession.getId()));
        mav.addObject("averageCost", orderItemService.getAverageCostBySellerId(userSession.getId()));
        mav.addObject("totalOrdered", orderItemService.getTotalOrderedBySellerId(userSession.getId()));
        mav.addObject("totalProductQuantity", productService.findAllByAvailableAndSellerId(true, userSession.getId()).size());
        mav.addObject("totalInStockProduct", productService.findAllInStockProductBySellerId(userSession.getId()).size());
        mav.addObject("totalPayment", paymentService.findAllBySellerId(userSession.getId()).size());
        mav.addObject("totalCustomer", userService.findAllCustomerBySellerId(userSession.getId()).size());

        return mav;
    }
}
