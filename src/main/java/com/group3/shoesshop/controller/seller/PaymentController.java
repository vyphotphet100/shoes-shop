package com.group3.shoesshop.controller.seller;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.entity.PaymentEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "payment-seller")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @GetMapping(value = "/seller/payment/payment-detail")
    public ModelAndView paymentDetail(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Payment/PaymentDetail/index");

        PaymentEntity payment = paymentService.findOne(id);
        mav.addObject("payment", payment);

        return mav;
    }

    @GetMapping(value = "/seller/payment/payment-list")
    public ModelAndView paymentList(HttpServletRequest request) {
        UserEntity userSession = (UserEntity)request.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession == null)
            return null;

        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Payment/PaymentList/index");
        List<PaymentEntity> payments = paymentService.findAll();
        mav.addObject("payments", paymentService.findAllBySellerId(userSession.getId()));
        return mav;
    }
}
