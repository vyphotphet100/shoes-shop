package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.PaymentDTO;

public interface IPaymentService extends IBaseService<PaymentDTO>{
    PaymentDTO findOne(Integer id);
    void delete(Integer id);
}
