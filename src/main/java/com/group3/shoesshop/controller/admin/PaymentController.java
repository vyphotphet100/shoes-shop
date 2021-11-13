package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.entity.PaymentEntity;
import com.group3.shoesshop.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping(value = "/admin/payment/payment-detail")
    public ModelAndView paymentDetail() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Payment/PaymentDetail/index");
        return mav;
    }

    @GetMapping(value = "/admin/payment/payment-list")
    public ModelAndView paymentList() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Payment/PaymentList/index");
        List<PaymentEntity> payments = paymentService.findAll();
        mav.addObject("payments", payments);
        return mav;
    }

}
