package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.PaymentMethodEntity;
import com.group3.shoesshop.service.IPaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService extends BaseService<PaymentMethodEntity> implements IPaymentMethodService {
    @Override
    public List<PaymentMethodEntity> findAll() {
        return null;
    }

    @Override
    public PaymentMethodEntity save(PaymentMethodEntity entity) {
        return null;
    }

    @Override
    public PaymentMethodEntity update(PaymentMethodEntity entity) {
        return null;
    }

    @Override
    public PaymentMethodEntity findOne(Integer id) {
        return null;
    }

    @Override
    public PaymentMethodEntity delete(Integer id) {
        return null;
    }
}
