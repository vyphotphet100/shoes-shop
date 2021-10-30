package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.PaymentDTO;
import com.group3.shoesshop.dto.TransferPaymentDTO;

public interface ITransferPaymentService extends IBaseService<TransferPaymentDTO>{
    TransferPaymentDTO findOne(Integer id);
    void delete(Integer id);
}
