package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.converter.dto_entity.mapper.TransferPaymentMapper;
import com.group3.shoesshop.entity.TransferPaymentEntity;
import com.group3.shoesshop.repository.TransferPaymentRepository;
import com.group3.shoesshop.service.ITransferPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferPaymentService extends BaseService<TransferPaymentEntity> implements ITransferPaymentService {
    @Autowired
    private TransferPaymentRepository transferPaymentRepo;

    @Autowired
    private TransferPaymentMapper transferPaymentMapper;

    @Override
    public List<TransferPaymentEntity> findAll() {
        return transferPaymentRepo.findAll();
    }

    @Override
    public TransferPaymentEntity save(TransferPaymentEntity entity) {
        TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(entity.getId()).orElse(null);
        if (transferPaymentEntity != null)
            return this.exceptionObject(new TransferPaymentEntity(), "This transfer payment exists already.");

        transferPaymentEntity = transferPaymentRepo.save(transferPaymentEntity);
        transferPaymentEntity.setMessage("Add transfer payment successfully.");
        return transferPaymentEntity;
    }

    @Override
    public TransferPaymentEntity update(TransferPaymentEntity entity) {
        TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(entity.getId()).orElse(null);
        if (transferPaymentEntity == null)
            return this.exceptionObject(new TransferPaymentEntity(), "This transfer payment does not exist.");

        transferPaymentEntity = transferPaymentRepo.save(transferPaymentEntity);
        transferPaymentEntity.setMessage("Update transfer payment successfully.");
        return transferPaymentEntity;
    }

    @Override
    public TransferPaymentEntity findOne(Integer id) {
        TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(id).orElse(null);
        if (transferPaymentEntity == null)
            return this.exceptionObject(new TransferPaymentEntity(), "This transfer payment id does not exist.");

        return transferPaymentEntity;
    }

    @Override
    public void delete(Integer id) {

    }
}
