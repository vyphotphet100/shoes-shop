package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class BuyerController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/admin/buyer/buyer-list")
    public ModelAndView buyerList() {
        ModelAndView modelAndView = new ModelAndView("Admin_Page/Pages/Customer/CustomerList/index");

        modelAndView.addObject("buyers", userService.findAllBuyer());

        return modelAndView;
    }

    @GetMapping(value = "/admin/buyer/edit")
    public ModelAndView editBuyer(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Customer/EditCustomer/index");

        mav.addObject("buyer", userService.findOne(id));
        return mav;
    }

}
