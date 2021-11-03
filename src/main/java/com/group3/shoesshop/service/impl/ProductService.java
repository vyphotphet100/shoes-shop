package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<ProductEntity> implements IProductService {
    @Override
    public List<ProductEntity> findAll() {
        return null;
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        return null;
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        return null;
    }

    @Override
    public ProductEntity findOne(String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}
