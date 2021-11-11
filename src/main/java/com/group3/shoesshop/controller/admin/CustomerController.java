package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.converter.dto_entity.mapper.UserMapper;
import com.group3.shoesshop.dto.UserDTO;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private IUserService userService;

    @Autowired
    private DTOEntityConverter dtoEntityConverter;

    @Autowired
    private UserMapper userMapper;

    private String baseUrl = "Admin_Page/Pages/Customer/";

    @GetMapping(value = "/admin/customer/customer-list")
    public ModelAndView customerList() {
        ModelAndView modelAndView = new ModelAndView("Admin_Page/Pages/Customer/CustomerList/index");

        modelAndView.addObject("customers", userService.findAllBuyer());

        return modelAndView;
    }

    @GetMapping(value = "/admin/customer/edit")
    public ModelAndView editCustomerGet(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Customer/EditCustomer/index");

        UserEntity customer = userService.findOne(id);
        mav.addObject("customer", customer);
        mav.addObject("ordered", userService.getOrderedItem(id));
        mav.addObject("totalSpent", userService.getTotalSpent(id));
        return mav;
    }

    @PostMapping(value = "/admin/customer/edit")
    public ModelAndView editCustomerPost(@ModelAttribute("customer") UserDTO userDto, ModelMap modelMap) {
        userService.update(dtoEntityConverter.toEntity(userDto, userMapper));
        return this.editCustomerGet(userDto.getId());
        //return null;
    }

}