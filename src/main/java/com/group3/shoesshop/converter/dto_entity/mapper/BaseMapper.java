package com.group3.shoesshop.converter.dto_entity.mapper;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.entity.BaseEntity;
import org.modelmapper.ModelMapper;

public abstract class BaseMapper<D, E> {
    protected D autoDTOMapper(BaseEntity entity, Class<D> tClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, tClass);
    }

    protected E autoEntityMapper(BaseDTO dto, Class<E> tClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, tClass);
    }

    public D mapToDTO(BaseEntity entity) {return null;}
    public E mapToEntity(BaseDTO dto) {return null;}
}
