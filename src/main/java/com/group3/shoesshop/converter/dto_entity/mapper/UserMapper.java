package com.group3.shoesshop.converter.dto_entity.mapper;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.dto.UserDTO;
import com.group3.shoesshop.entity.*;
import com.group3.shoesshop.repository.OrderItemRepository;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.repository.TransferPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper extends BaseMapper<UserDTO, UserEntity>{
    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private TransferPaymentRepository transferPaymentRepo;

    @Override
    public UserDTO mapToDTO(BaseEntity entity) {
        if (entity == null)
            return null;
        UserDTO userDto = this.autoDTOMapper(entity, UserDTO.class);
        UserEntity userEntity = (UserEntity) entity;

        // products
        if (userEntity.getProducts() != null)
            for (ProductEntity productEntity : ((CategoryEntity) entity).getProducts())
                userDto.getProductCodes().add(productEntity.getCode());

        // order items
        if (userEntity.getOrderItems() != null) {
            for (OrderItemEntity orderItemEntity: userEntity.getOrderItems())
                userDto.getOrderItemIds().add(orderItemEntity.getId());
        }

        // admin transfer payments
        if (userEntity.getAdminTransferPayments() != null)
            for (TransferPaymentEntity transferPaymentEntity: userEntity.getAdminTransferPayments())
                userDto.getAdminTransferPaymentIds().add(transferPaymentEntity.getId());

        // seller transfer payments
        if (userEntity.getSellerTransferPayments() != null)
            for (TransferPaymentEntity transferPaymentEntity: userEntity.getSellerTransferPayments())
                userDto.getSellerTransferPaymentIds().add(transferPaymentEntity.getId());

        return userDto;
    }

    @Override
    public UserEntity mapToEntity(BaseDTO dto) {
        if (dto == null)
            return null;
        UserEntity userEntity = this.autoEntityMapper(dto, UserEntity.class);
        UserDTO userDto = (UserDTO) dto;

        // products
        if (userDto.getProductCodes() != null)
            for (String code: userDto.getProductCodes()) {
                ProductEntity productEntity = productRepo.findById(code).orElse(null);
                if (productEntity != null)
                    userEntity.getProducts().add(productEntity);
            }

        // order items
        if (userDto.getOrderItemIds() != null) {
            for (Integer id : userDto.getOrderItemIds()){
                OrderItemEntity orderItemEntity = orderItemRepo.findById(id).orElse(null);
                if (orderItemEntity != null)
                    userEntity.getOrderItems().add(orderItemEntity);
            }
        }

        // admin transfer payments
        if (userDto.getAdminTransferPaymentIds() != null) {
            for (Integer id: userDto.getAdminTransferPaymentIds()) {
                TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(id).orElse(null);
                if (transferPaymentEntity != null)
                    userEntity.getAdminTransferPayments().add(transferPaymentEntity);
            }
        }

        // seller transfer payments
        if (userDto.getSellerTransferPaymentIds() != null) {
            for (Integer id: userDto.getSellerTransferPaymentIds()) {
                TransferPaymentEntity transferPaymentEntity = transferPaymentRepo.findById(id).orElse(null);
                if (transferPaymentEntity != null)
                    userEntity.getSellerTransferPayments().add(transferPaymentEntity);
            }
        }

        return userEntity;
    }
}
