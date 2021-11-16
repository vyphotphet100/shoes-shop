package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.ProductEntity;

import java.util.List;

public interface IProductService extends IBaseService<ProductEntity>{
    ProductEntity findOne(String code);
    ProductEntity delete(String code);

    List<ProductEntity> findAllByAvailableAndSellerId(Boolean available, Integer id);
}
