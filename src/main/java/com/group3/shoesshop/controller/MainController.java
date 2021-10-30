package com.group3.shoesshop.controller;

import com.group3.shoesshop.dto.UserDTO;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private IUserService userService;

    @GetMapping("/test")
    public UserDTO test() {
        UserDTO userDto = userService.findByUsernameAndPassword("user1", "123456");
        return userDto;
    }

}
