package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.PaymentEntity;

public interface IPaymentService extends IBaseService<PaymentEntity>{
    PaymentEntity findOne(Integer id);
    void delete(Integer id);
}
