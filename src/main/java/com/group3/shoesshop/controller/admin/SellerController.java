package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.entity.RoleEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/admin/seller/add")
    public ModelAndView addSellerGet(UserEntity seller) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Seller/AddSeller/index");

        if (seller == null)
            mav.addObject("seller", new UserEntity());
        else
            mav.addObject("seller", seller);

        return mav;
    }

    @PostMapping(value = "/admin/seller/add")
    public ModelAndView addSellerPost(@ModelAttribute UserEntity seller) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCode("SELLER");
        seller.setRole(roleEntity);
        seller = userService.save(seller);

        return this.addSellerGet(seller);
    }


    @GetMapping(value = "/admin/seller/seller-list")
    public ModelAndView sellerList() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Seller/SellerList/index");

        mav.addObject("sellers", userService.findAllSeller());

        return mav;
    }

    @GetMapping(value = "/admin/seller/edit")
    public ModelAndView editSellerGet(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Seller/EditSeller/index");

        if (id == null)
            return null;

        UserEntity seller = userService.findOne(id);
        mav.addObject("seller", seller);

        return mav;
    }

    @PostMapping(value = "/admin/seller/edit")
    public ModelAndView editSellerPost(@ModelAttribute UserEntity seller) {
        userService.update(seller);
        return new ModelAndView("redirect:/admin/seller/edit?id=" + seller.getId());
    }

    @DeleteMapping(value = "/admin/seller/delete")
    public ResponseEntity<UserEntity> deleteSeller(@RequestParam Integer id) {
        UserEntity userEntity = userService.delete(id);
        return new ResponseEntity<UserEntity>(new UserEntity(), userEntity.getHttpStatus());
    }

}
