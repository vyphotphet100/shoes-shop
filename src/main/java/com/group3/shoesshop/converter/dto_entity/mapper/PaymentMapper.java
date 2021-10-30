package com.group3.shoesshop.converter.dto_entity.mapper;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.dto.PaymentDTO;
import com.group3.shoesshop.entity.BaseEntity;
import com.group3.shoesshop.entity.PaymentEntity;

public class PaymentMapper extends BaseMapper<PaymentDTO, PaymentEntity>{
    @Override
    public PaymentDTO mapToDTO(BaseEntity entity) {
        if (entity == null)
            return null;

        PaymentDTO paymentDTO = this.autoDTOMapper(entity, PaymentDTO.class);

        return paymentDTO;
    }

    @Override
    public PaymentEntity mapToEntity(BaseDTO dto) {
        if (dto == null)
            return null;

        PaymentEntity paymentEntity = this.autoEntityMapper(dto, PaymentEntity.class);

        return paymentEntity;
    }
}
