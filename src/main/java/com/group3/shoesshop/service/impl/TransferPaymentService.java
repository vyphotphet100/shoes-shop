package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.converter.dto_entity.mapper.TransferPaymentMapper;
import com.group3.shoesshop.dto.TransferPaymentDTO;
import com.group3.shoesshop.entity.TransferPaymentEntity;
import com.group3.shoesshop.repository.TransferPaymentRepository;
import com.group3.shoesshop.service.ITransferPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferPaymentService extends BaseService<TransferPaymentDTO> implements ITransferPaymentService {
    @Autowired
    private TransferPaymentRepository transferPaymentRepo;

    @Autowired
    private TransferPaymentMapper transferPaymentMapper;

    @Override
    public List<TransferPaymentDTO> findAll() {
        List<TransferPaymentDTO> transferPaymentDtos = new ArrayList<>();
        List<TransferPaymentEntity> transferPaymentEntities = transferPaymentRepo.findAll();
        for (TransferPaymentEntity transferPaymentEntity: transferPaymentEntities)
            transferPaymentDtos.add(dtoEntityConverter.toDTO(transferPaymentEntity, transferPaymentMapper));

        return transferPaymentDtos;
    }

    @Override
    public TransferPaymentDTO save(TransferPaymentDTO dto) {
        TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(dto.getId()).orElse(null);
        if (transferPaymentEntity != null)
            return this.exceptionObject(new TransferPaymentDTO(), "This transfer payment exists already.");

        transferPaymentEntity = transferPaymentRepo.save(transferPaymentEntity);
        TransferPaymentDTO transferPaymentDto = dtoEntityConverter.toDTO(transferPaymentEntity, transferPaymentMapper);
        transferPaymentDto.setMessage("Add transfer payment successfully.");
        return transferPaymentDto;
    }

    @Override
    public TransferPaymentDTO update(TransferPaymentDTO dto) {
        TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(dto.getId()).orElse(null);
        if (transferPaymentEntity == null)
            return this.exceptionObject(new TransferPaymentDTO(), "This transfer payment does not exist.");

        transferPaymentEntity = transferPaymentRepo.save(transferPaymentEntity);
        TransferPaymentDTO transferPaymentDto = dtoEntityConverter.toDTO(transferPaymentEntity, transferPaymentMapper);
        transferPaymentDto.setMessage("Update transfer payment successfully.");
        return transferPaymentDto;
    }

    @Override
    public TransferPaymentDTO findOne(Integer id) {
        TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(id).orElse(null);
        if (transferPaymentEntity == null)
            return this.exceptionObject(new TransferPaymentDTO(), "This transfer payment id does not exist.");

        return dtoEntityConverter.toDTO(transferPaymentEntity, transferPaymentMapper);
    }

    @Override
    public void delete(Integer id) {

    }
}
