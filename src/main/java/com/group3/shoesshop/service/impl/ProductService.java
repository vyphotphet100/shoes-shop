package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends BaseService<ProductEntity> implements IProductService {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<ProductEntity> findAll() {
        return productRepo.findAllByIsAvailable(true);
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        entity.setCode(MyUtils.generateRandomString(5));
        ProductEntity productEntity = productRepo.save(entity);
        productEntity.setMessage("Add product successfully");
        return productEntity;
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        ProductEntity productEntity = productRepo.findById(entity.getCode()).orElse(null);
        if (productEntity == null)
            return this.exceptionObject(new ProductEntity(), "This product does not exist");

        BeanUtils.copyProperties(entity, productEntity, getNullPropertyNames(entity));
        productEntity = productRepo.save(productEntity);
        productEntity.setMessage("Update product successfully.");
        return productEntity;
    }

    @Override
    public ProductEntity findOne(String code) {
        return productRepo.findById(code).orElse(null);
    }

    @Override
    public ProductEntity delete(String code) {
        ProductEntity productEntity = productRepo.findById(code).orElse(null);
        if (productEntity == null)
            return this.exceptionObject(new ProductEntity(), "This product does not exist");

        productEntity.setIsAvailable(false);
        productEntity = this.update(productEntity);
        productEntity.setMessage("Delete product successfully");
        return productEntity;
    }
}
