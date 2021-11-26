package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import java.util.List;

public interface IPayPalService {
    String authorizePayment(List<OrderItemEntity> orderItemEntities) throws PayPalRESTException;
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
    Payment getPaymentDetails(String paymentId) throws PayPalRESTException;
}
