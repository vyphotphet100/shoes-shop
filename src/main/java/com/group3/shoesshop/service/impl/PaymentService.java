package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.PaymentDTO;
import com.group3.shoesshop.service.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService extends BaseService<PaymentDTO> implements IPaymentService {
    @Override
    public List<PaymentDTO> findAll() {
        return null;
    }

    @Override
    public PaymentDTO save(PaymentDTO dto) {
        return null;
    }

    @Override
    public PaymentDTO update(PaymentDTO dto) {
        return null;
    }

    @Override
    public PaymentDTO findOne(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
