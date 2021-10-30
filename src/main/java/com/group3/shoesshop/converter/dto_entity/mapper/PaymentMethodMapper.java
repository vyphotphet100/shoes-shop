package com.group3.shoesshop.converter.dto_entity.mapper;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.dto.PaymentMethodDTO;
import com.group3.shoesshop.entity.BaseEntity;
import com.group3.shoesshop.entity.PaymentMethodEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodMapper extends BaseMapper<PaymentMethodDTO, PaymentMethodEntity>{
    @Autowired
    private UserRepository userRepo;

    @Override
    public PaymentMethodDTO mapToDTO(BaseEntity entity) {
        if (entity == null)
            return null;
        PaymentMethodDTO paymentMethodDto = this.autoDTOMapper(entity, PaymentMethodDTO.class);

        // users
        PaymentMethodEntity paymentMethodEntity = (PaymentMethodEntity) entity;
        if (paymentMethodEntity.getUsers() != null) {
            for (UserEntity userEntity: paymentMethodEntity.getUsers())
                paymentMethodDto.getUserIds().add(userEntity.getId());
        }

        return paymentMethodDto;
    }

    @Override
    public PaymentMethodEntity mapToEntity(BaseDTO dto) {
        if (dto == null)
            return null;
        PaymentMethodEntity paymentMethodEntity = this.autoEntityMapper(dto, PaymentMethodEntity.class);

        // users
        PaymentMethodDTO paymentMethodDto = (PaymentMethodDTO) dto;
        if (paymentMethodDto.getUserIds() != null) {
            for (Integer id : paymentMethodDto.getUserIds()){
                UserEntity userEntity = userRepo.findById(id).orElse(null);
                if (userEntity != null)
                    paymentMethodEntity.getUsers().add(userEntity);
            }
        }

        return paymentMethodEntity;
    }
}
