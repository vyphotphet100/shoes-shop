package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T> implements IBaseService<T> {

    @Autowired
    protected DTOEntityConverter dtoEntityConverter;

    public T exceptionObject(BaseDTO dto, String message) {
        dto.setMessage(message);
        dto.setHttpStatus(HttpStatus.EXPECTATION_FAILED);

        return (T)dto;
    }

    public T forbiddenObject(BaseDTO dto, String message) {
        dto.setMessage(message);
        dto.setHttpStatus(HttpStatus.FORBIDDEN);

        return (T) dto;
    }
}
