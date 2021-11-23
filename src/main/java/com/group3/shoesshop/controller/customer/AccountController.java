package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.converter.dto_entity.mapper.UserMapper;
import com.group3.shoesshop.dto.UserDTO;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.RoleEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IOrderItemService;
import com.group3.shoesshop.service.IRoleService;
import com.group3.shoesshop.service.IUserService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController extends BaseController {
    @Autowired
    private DTOEntityConverter converter;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/customer/my-account/account")
    public ModelAndView account(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/Account/index");

        return returnModelAndView(request, mav);
    }

    @GetMapping(value = "/customer/my-account/change-password")
    public ModelAndView changePassword(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/ChangePassword/index");

        return returnModelAndView(request, mav);
    }

    @PutMapping(value = "/customer/my-account/change-password")
    public ResponseEntity<UserDTO> changePasswordPut(HttpServletRequest request, @RequestBody UserEntity userEntity) {
        String oldPassword = userEntity.getListRequest().get(0).toString();
        String newPassword = userEntity.getListRequest().get(1).toString();
        String confirmPassword = userEntity.getListRequest().get(2).toString();
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return null;

        UserDTO userDto = new UserDTO();
        if (!userSession.getPassword().equals(oldPassword)) {
            userDto.setMessage("Old password is wrong");
            return new ResponseEntity<UserDTO>(userDto, HttpStatus.FORBIDDEN);
        }

        if (!newPassword.equals(confirmPassword)) {
            userDto.setMessage("Confirm password is wrong");
            return new ResponseEntity<UserDTO>(userDto, HttpStatus.FORBIDDEN);
        }

        if (newPassword.equals(null) || newPassword.trim().equals("")) {
            userDto.setMessage("New password is invalid");
            return new ResponseEntity<UserDTO>(userDto, HttpStatus.FORBIDDEN);
        }

        userSession.setPassword(newPassword);
        userDto = converter.toDTO(userService.update(userSession), userMapper);
        return new ResponseEntity<UserDTO>(userDto, userDto.getHttpStatus());
    }

    @GetMapping(value = "/customer/my-account/edit-account")
    public ModelAndView editAccount(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/EditAccount/index");

        return returnModelAndView(request, mav);
    }

    @PutMapping(value = "/customer/my-account/edit-account")
    public ResponseEntity<UserDTO> editAccountPut(HttpServletRequest request, @RequestBody UserEntity userEntity) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return null;

        userEntity.setId(userSession.getId());
        UserEntity resEntity = userService.update(userEntity);
        if (resEntity.getHttpStatus().equals(HttpStatus.OK))
            request.getSession().setAttribute(Constant.USER_SESSION, resEntity);
        return new ResponseEntity<UserDTO>(converter.toDTO(resEntity, userMapper), resEntity.getHttpStatus());
    }

    @GetMapping(value = "/customer/my-account/create-seller")
    public ModelAndView createSeller(HttpServletRequest request, UserEntity user) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/CreateSeller/index");

        if (user == null)
            mav.addObject("user", new UserEntity());
        else
            mav.addObject("user", user);

        return returnModelAndView(request, mav);
    }

    @PostMapping(value = "/customer/my-account/create-seller")
    public ModelAndView createSellerPost(HttpServletRequest request, @ModelAttribute UserEntity user) {
        user.setRole(roleService.findOne(Constant.ROLE_SELLER));
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            user = userService.exceptionObject(user, "Confirm password is not matched");
            return this.register(request, user);
        }

        UserEntity resEntity = userService.save(user);

        if (!resEntity.getHttpStatus().equals(HttpStatus.OK))
            return this.register(request, resEntity);

        return this.login(request, resEntity);
    }

    @GetMapping(value = "/customer/my-account/login")
    public ModelAndView login(HttpServletRequest request, UserEntity user) {
        if (MyUtils.getUserFromSession(request) != null)
            return new ModelAndView("redirect:/customer/my-account/account");

        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/Login/index");
        if (user == null)
            mav.addObject("user", new UserEntity());
        else
            mav.addObject("user", user);
        return returnModelAndView(request, mav);
    }

    @PostMapping(value = "/customer/my-account/login")
    public ModelAndView loginPost(HttpServletRequest request, @ModelAttribute UserEntity user) {
        UserEntity resEntity = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (!resEntity.getHttpStatus().equals(HttpStatus.OK))
            return this.login(request, resEntity);
        request.getSession().setAttribute(Constant.USER_SESSION, resEntity);

        // redirect to true page
        if (resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN))
            return new ModelAndView("redirect:/admin/customer/customer-list");
        else if (resEntity.getRole().getCode().equals(Constant.ROLE_SELLER))
            return new ModelAndView("redirect:/seller/product/product-list");
        else
            return new ModelAndView("redirect:/home");

    }

    @GetMapping(value = "/customer/my-account/register")
    public ModelAndView register(HttpServletRequest request, UserEntity user) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/Register/index");
        if (user != null)
            mav.addObject("user", user);
        else
            mav.addObject("user", new UserEntity());
        return returnModelAndView(request, mav);
    }

    @PostMapping(value = "/customer/my-account/register")
    public ModelAndView registerPost(HttpServletRequest request, @ModelAttribute UserEntity user) {
        user.setRole(roleService.findOne(Constant.ROLE_CUSTOMER));
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            user = userService.exceptionObject(user, "Confirm password is not matched");
            return this.register(request, user);
        }

        UserEntity resEntity = userService.save(user);

        if (!resEntity.getHttpStatus().equals(HttpStatus.OK))
            return this.register(request, resEntity);

        return this.login(request, resEntity);
    }

    @GetMapping(value = "/customer/my-account/order-history-detail")
    public ModelAndView orderHistoryDetail(HttpServletRequest request, @RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/OrderHistoryDetail/index");

        if (id == null)
            return null;

        OrderItemEntity orderItemEntity = orderItemService.findOne(id);
        if (orderItemEntity == null)
            return null;

        mav.addObject("orderItem", orderItemEntity);
        return returnModelAndView(request, mav);
    }

    @GetMapping(value = "/customer/my-account/order-history")
    public ModelAndView orderHistory(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/Customer_Page/Pages/MyAccount/OrderHistory/index");
        UserEntity user = userService.findOne(MyUtils.getUserFromSession(request).getId());
        mav.addObject("user", user);
        return returnModelAndView(request, mav);
    }


}
