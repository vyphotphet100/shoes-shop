package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.PaymentMethodDTO;

public interface IPaymentMethodService extends IBaseService<PaymentMethodDTO>{
    PaymentMethodDTO findOne(Integer id);
    void delete(Integer id);
}
