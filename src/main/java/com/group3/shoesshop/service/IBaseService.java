package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.BaseEntity;

import javax.persistence.Query;
import java.util.List;

public interface IBaseService<T> {
    Query createNativeQuery(String query, Class<T> clazz);
    T exceptionObject(BaseEntity entity, String message);
    List<T> findAll();
    T save(T entity);
    T update(T entity);
}
