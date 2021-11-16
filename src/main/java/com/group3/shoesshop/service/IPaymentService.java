package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.PaymentEntity;

import java.util.List;

public interface IPaymentService extends IBaseService<PaymentEntity>{
    PaymentEntity findOne(Integer id);
    PaymentEntity delete(Integer id);

    List<PaymentEntity> findAllBySellerId(Integer id);
}
