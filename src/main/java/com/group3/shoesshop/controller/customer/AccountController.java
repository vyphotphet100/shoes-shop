package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.entity.OrderItemEntity;
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
    private IRoleService roleService;

    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/customer/my-account/account")
    public ModelAndView account(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/Account/index");

        return returnModelAndView(request, mav);
    }

    @GetMapping(value = "/customer/my-account/change-password")
    public ModelAndView changePassword(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/ChangePassword/index");

        return returnModelAndView(request, mav);
    }

    @PutMapping(value = "/customer/my-account/change-password")
    public ResponseEntity<UserEntity> changePasswordPut(HttpServletRequest request, @RequestBody UserEntity userEntity) {
        String oldPassword = (String)userEntity.getListRequest().values().toArray()[0];
        String newPassword = userEntity.getListRequest().values().toArray()[1].toString();
        String confirmPassword = userEntity.getListRequest().values().toArray()[2].toString();
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return null;

//        UserDTO userDto = new UserDTO();
        UserEntity resEntity = new UserEntity();
        if (!userSession.getPassword().equals(oldPassword)) {
            resEntity = userService.exceptionObject(resEntity, "Old password is wrong").toLaziness();
            return new ResponseEntity<UserEntity>(resEntity, resEntity.getHttpStatus());
        }

        if (!newPassword.equals(confirmPassword)) {
            resEntity = userService.exceptionObject(resEntity, "Confirm password is wrong").toLaziness();
            return new ResponseEntity<UserEntity>(resEntity, resEntity.getHttpStatus());
        }

        if (newPassword.equals(null) || newPassword.trim().equals("")) {
            resEntity = userService.exceptionObject(resEntity, "New password is invalid").toLaziness();
            return new ResponseEntity<UserEntity>(resEntity, resEntity.getHttpStatus());
        }

        userSession.setPassword(newPassword);
        resEntity = userService.update(userSession).toLaziness();
        return new ResponseEntity<UserEntity>(resEntity, resEntity.getHttpStatus());
    }

    @GetMapping(value = "/customer/my-account/edit-account")
    public ModelAndView editAccount(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/EditAccount/index");

        return returnModelAndView(request, mav);
    }

    @PutMapping(value = "/customer/my-account/edit-account")
    public ResponseEntity<UserEntity> editAccountPut(HttpServletRequest request, @RequestBody UserEntity userEntity) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return null;

        userEntity.setId(userSession.getId());
        UserEntity resEntity = userService.update(userEntity);
        if (resEntity.getHttpStatus().equals(HttpStatus.OK))
            request.getSession().setAttribute(Constant.USER_SESSION, resEntity);
        resEntity = resEntity.toLaziness();
        return new ResponseEntity<UserEntity>(resEntity, resEntity.getHttpStatus());
    }

    @GetMapping(value = "/customer/my-account/create-seller")
    public ModelAndView createSeller(HttpServletRequest request, UserEntity user) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/CreateSeller/index");

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
    public ModelAndView login(HttpServletRequest request, UserEntity user){
        if (MyUtils.getUserFromSession(request) != null)
            return new ModelAndView("redirect:/customer/my-account/account");

        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/Login/index");
        if (user == null)
            mav.addObject("user", new UserEntity());
        else {
            mav.addObject("user", user);
        }

        return returnModelAndView(request, mav);
    }

    @PostMapping(value = "/customer/my-account/login")
    public ModelAndView loginPost(HttpServletRequest request, @ModelAttribute UserEntity user) {
        UserEntity resEntity = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (!resEntity.getHttpStatus().equals(HttpStatus.OK))
            return this.login(request, resEntity);
        // set authorities for user
        if (resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN))
            resEntity.setMyAuthorities(Constant.ROLE_ADMIN_CAN);
        else if (resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN1))
            resEntity.setMyAuthorities(Constant.ROLE_ADMIN1_CAN);
        else if (resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN2))
            resEntity.setMyAuthorities(Constant.ROLE_ADMIN2_CAN);
        else if (resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN3))
            resEntity.setMyAuthorities(Constant.ROLE_ADMIN3_CAN);

        // save user to session
        request.getSession().setAttribute(Constant.USER_SESSION, resEntity);

        // redirect to true page
        if (resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN) ||
                resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN1) ||
                resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN2) ||
                resEntity.getRole().getCode().equals(Constant.ROLE_ADMIN3))
            return new ModelAndView("redirect:/admin/dashboard");
        else if (resEntity.getRole().getCode().equals(Constant.ROLE_SELLER))
            return new ModelAndView("redirect:/seller/dashboard");
        else
            return new ModelAndView("redirect:/home");

    }

    @GetMapping(value = "/customer/my-account/register")
    public ModelAndView register(HttpServletRequest request, UserEntity user) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/Register/index");
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
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/OrderHistoryDetail/index");

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
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/MyAccount/OrderHistory/index");
        UserEntity user = userService.findOneByIsActiveAndId(true, MyUtils.getUserFromSession(request).getId());
        mav.addObject("user", user);
        return returnModelAndView(request, mav);
    }
}
