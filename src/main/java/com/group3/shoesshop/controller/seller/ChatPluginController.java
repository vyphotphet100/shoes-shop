package com.group3.shoesshop.controller.seller;

import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IUserService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatPluginController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/seller/plugin/add-chat")
    public ModelAndView addChat(HttpServletRequest request) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Plugin/Chat/index");
        mav.addObject("user", userService.findOneByIsActiveAndId(true, userSession.getId()));
        return mav;
    }

    @PostMapping(value = "/seller/plugin/add-chat")
    public ModelAndView addChatPost(HttpServletRequest request, @ModelAttribute UserEntity user) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Plugin/Chat/index");
        UserEntity userEntity = userService.findOneByIsActiveAndId(true, userSession.getId());
        userEntity.setChatPluginScript(user.getChatPluginScript());
        userEntity = userService.update(userEntity);
        mav.addObject("user", userEntity);
        return mav;
    }
}
