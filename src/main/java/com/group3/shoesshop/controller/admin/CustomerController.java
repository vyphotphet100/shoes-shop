package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private IUserService userService;

    private String baseUrl = "Admin_Page/Pages/Customer/";

    @GetMapping(value = "/admin/customer/customer-list")
    public ModelAndView customerList(@RequestParam(value = "keyword", required = false) String keyword) {
        ModelAndView modelAndView = new ModelAndView("Admin_Page/Pages/Customer/CustomerList/index");

        if (keyword == null)
            modelAndView.addObject("customers", userService.findAllBuyerByIsActive(true));
        else
            modelAndView.addObject("customers", userService.findAllBuyerByIsActiveAndKeyword(true, keyword));

        return modelAndView;
    }

    @DeleteMapping(value = "/admin/customer/delete")
    public ResponseEntity<UserEntity> deleteCustomer(@RequestParam Integer id) {
        UserEntity userEntity = userService.delete(id).toLaziness();
        return new ResponseEntity<UserEntity>(userEntity, userEntity.getHttpStatus());
    }

    @GetMapping(value = "/admin/customer/edit")
    public ModelAndView editCustomerGet(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Customer/EditCustomer/index");

        UserEntity customer = userService.findOneByIsActiveAndId(true, id);
        mav.addObject("customer", customer);
        mav.addObject("ordered", userService.getOrderedItem(id));
        mav.addObject("totalSpent", userService.getTotalSpent(id));
        return mav;
    }

    @PostMapping(value = "/admin/customer/edit")
    public ModelAndView editCustomerPost(@ModelAttribute("customer") UserEntity userEntity) {
        userService.update(userEntity);
        return new ModelAndView("redirect:/admin/customer/edit?id=" + userEntity.getId());
        //return null;
    }

}
