package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    private IUserService userService;
    @GetMapping(value = "/customer/my-account/account")
    public ModelAndView account() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/Account/index");

        return mav;
    }

    @GetMapping(value = "/customer/my-account/change-password")
    public ModelAndView changePassword() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/ChangePassword/index");

        return mav;
    }

    @GetMapping(value = "/customer/my-account/edit-account")
    public ModelAndView editAccount() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/EditAccount/index");

        return mav;
    }

    @GetMapping(value = "/customer/my-account/create-seller")
    public ModelAndView createSeller() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/CreateSeller/index");

        return mav;
    }

    @GetMapping(value = "/customer/my-account/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/Login/index");

        return mav;
    }

    @GetMapping(value = "/customer/my-account/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/Register/index");

        return mav;
    }

    @GetMapping(value = "/customer/my-account/order-history-detail")
    public ModelAndView orderHistoryDetail() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/OrderHistoryDetail/index");

        return mav;
    }

    @GetMapping(value = "/customer/my-account/order-history")
    public ModelAndView orderHistory() {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/OrderHistory/index");

        return mav;
    }


}
