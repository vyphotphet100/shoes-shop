//package com.group3.shoesshop.converter.dto_entity.mapper;
//
//import com.group3.shoesshop.dto.BaseDTO;
//import com.group3.shoesshop.dto.TransferPaymentDTO;
//import com.group3.shoesshop.entity.BaseEntity;
//import com.group3.shoesshop.entity.TransferPaymentEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TransferPaymentMapper extends BaseMapper<TransferPaymentDTO, TransferPaymentEntity>{
//    @Override
//    public TransferPaymentDTO mapToDTO(BaseEntity entity) {
//        if (entity == null)
//            return null;
//
//        TransferPaymentDTO transferPaymentDto = this.autoDTOMapper(entity, TransferPaymentDTO.class);
//
//        return transferPaymentDto;
//    }
//
//    @Override
//    public TransferPaymentEntity mapToEntity(BaseDTO dto) {
//        if (dto == null)
//            return null;
//
//        TransferPaymentEntity transferPaymentEntity = this.autoEntityMapper(dto, TransferPaymentEntity.class);
//
//        return transferPaymentEntity;
//    }
//}
