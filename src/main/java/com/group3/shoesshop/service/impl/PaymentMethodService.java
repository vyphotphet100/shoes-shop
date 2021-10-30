package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.PaymentMethodDTO;
import com.group3.shoesshop.service.IPaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService extends BaseService<PaymentMethodDTO> implements IPaymentMethodService {
    @Override
    public List<PaymentMethodDTO> findAll() {
        return null;
    }

    @Override
    public PaymentMethodDTO save(PaymentMethodDTO dto) {
        return null;
    }

    @Override
    public PaymentMethodDTO update(PaymentMethodDTO dto) {
        return null;
    }

    @Override
    public PaymentMethodDTO findOne(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
