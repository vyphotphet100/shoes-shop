package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.PaymentMethodEntity;

public interface IPaymentMethodService extends IBaseService<PaymentMethodEntity>{
    PaymentMethodEntity findOne(Integer id);
    PaymentMethodEntity delete(Integer id);
}
