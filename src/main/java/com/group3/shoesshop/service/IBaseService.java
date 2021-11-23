package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.BaseEntity;

import java.util.List;

public interface IBaseService<T> {
    T exceptionObject(BaseEntity entity, String message);
    List<T> findAll();
    T save(T entity);
    T update(T entity);
}
