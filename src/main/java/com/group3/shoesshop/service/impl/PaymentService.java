package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.PaymentEntity;
import com.group3.shoesshop.repository.PaymentRepository;
import com.group3.shoesshop.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService extends BaseService<PaymentEntity> implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepo;

    @Override
    public List<PaymentEntity> findAll() {
        return paymentRepo.findAll();
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
        return paymentRepo.findById(id).orElse(null);
    }

    @Override
    public PaymentEntity delete(Integer id) {
        return null;
    }
}
