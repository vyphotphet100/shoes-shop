package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.PaymentEntity;
import com.group3.shoesshop.service.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService extends BaseService<PaymentEntity> implements IPaymentService {
    @Override
    public List<PaymentEntity> findAll() {
        return null;
    }

    @Override
    public PaymentEntity save(PaymentEntity entity) {
        return null;
    }

    @Override
    public PaymentEntity update(PaymentEntity entity) {
        return null;
    }

    @Override
    public PaymentEntity findOne(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
