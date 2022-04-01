package com.group3.shoesshop.controller.seller;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IOrderItemService;
import com.group3.shoesshop.service.IUserService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "customer-seller")
public class CustomerController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderItemService orderItemService;

    @GetMapping(value = "/seller/customer/customer-list")
    public ModelAndView customerList(HttpServletRequest request) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Customer/CustomerList/index");
        mav.addObject("customers", userService.findAllCustomerBySellerId(userSession.getId()));
        return mav;
    }

    @GetMapping(value = "/seller/customer/customer-detail")
    public ModelAndView customerDetail(HttpServletRequest request, @RequestParam Integer id) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null)
            return new ModelAndView("redirect:/customer/my-account/login");

        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Customer/Customer/index");
        UserEntity customer = userService.findOneByIsActiveAndId(true, id);
        List<OrderItemEntity> orderItemEntities = orderItemService.findAllByCustomerIdAndSellerId(id, userSession.getId());
        mav.addObject("customer", customer);
        mav.addObject("orderItems", orderItemEntities);
        mav.addObject("ordered", orderItemEntities.size());
        mav.addObject("totalSpent", orderItemService.getTotalCostOfOrderItemList(orderItemEntities));
        return mav;
    }
}
