package com.group3.shoesshop.converter.dto_entity;

import com.group3.shoesshop.converter.dto_entity.mapper.BaseMapper;
import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.entity.BaseEntity;
import org.springframework.stereotype.Service;

@Service
public class DTOEntityConverter {
    public <D, E> D toDTO(BaseEntity entity, BaseMapper<D, E> mapper) {
        if (entity == null)
            return null;
        return mapper.mapToDTO(entity);
    }

    public <D, E> E toEntity(BaseDTO dto, BaseMapper<D, E> mapper) {
        if (dto == null)
            return null;
        return mapper.mapToEntity(dto);
    }
}
