package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.BaseEntity;
import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.service.IBaseService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public abstract class BaseService<T> implements IBaseService<T> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Query createNativeQuery(String query, Class<T> clazz) {
        return entityManager.createNativeQuery(query, clazz);
    }

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

    protected String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    protected List<ProductEntity> getProductByIsAvailable(List<ProductEntity> productEntities, Boolean available) {
        List<ProductEntity> resEntities = new ArrayList<>();
        for (ProductEntity productEntity: productEntities)
            if (productEntity.getIsAvailable().equals(available))
                resEntities.add(productEntity);

        return resEntities;
    }
}
