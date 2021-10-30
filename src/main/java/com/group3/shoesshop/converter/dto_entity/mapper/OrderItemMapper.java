package com.group3.shoesshop.converter.dto_entity.mapper;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.dto.OrderItemDTO;
import com.group3.shoesshop.entity.BaseEntity;
import com.group3.shoesshop.entity.OrderItemEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderItemMapper extends BaseMapper<OrderItemDTO, OrderItemEntity>{
    @Override
    public OrderItemDTO mapToDTO(BaseEntity entity) {
        if (entity == null)
            return null;

        OrderItemDTO orderItemDto = this.autoDTOMapper(entity, OrderItemDTO.class);

        return orderItemDto;
    }

    @Override
    public OrderItemEntity mapToEntity(BaseDTO dto) {
        if (dto == null)
            return null;

        OrderItemEntity orderItemEntity = this.autoEntityMapper(dto, OrderItemEntity.class);

        return orderItemEntity;
    }

}
