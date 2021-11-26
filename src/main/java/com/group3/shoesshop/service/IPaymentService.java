package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.PaymentEntity;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import java.util.List;

public interface IPaymentService extends IBaseService<PaymentEntity>{
    PaymentEntity findOne(Integer id);
    PaymentEntity delete(Integer id);

    List<PaymentEntity> findAllBySellerId(Integer id);

}
