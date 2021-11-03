package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.ProductEntity;

public interface IProductService extends IBaseService<ProductEntity>{
    ProductEntity findOne(String code);
    void delete(String code);
}
