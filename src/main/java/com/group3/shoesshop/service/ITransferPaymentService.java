package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.TransferPaymentEntity;

public interface ITransferPaymentService extends IBaseService<TransferPaymentEntity>{
    TransferPaymentEntity findOne(Integer id);
    TransferPaymentEntity delete(Integer id);
}
