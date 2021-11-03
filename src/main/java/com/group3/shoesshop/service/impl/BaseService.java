package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.entity.BaseEntity;
import com.group3.shoesshop.service.IBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T> implements IBaseService<T> {

    public T exceptionObject(BaseEntity entity, String message) {
        entity.setMessage(message);
        entity.setHttpStatus(HttpStatus.EXPECTATION_FAILED);

        return (T)entity;
    }

    public T forbiddenObject(BaseEntity entity, String message) {
        entity.setMessage(message);
        entity.setHttpStatus(HttpStatus.FORBIDDEN);

        return (T) entity;
    }
}
