package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
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
        if (entity.getPictureUrl() == null && entity.getPictureUrl().trim().equals(""))
            return this.exceptionObject(new ProductEntity(), "Please add picture product");

        // up picture to cloud
        if (!entity.getPictureUrl().startsWith("http") && !entity.getPictureUrl().contains("file?name=")) {
            byte[] pictueBytes = Base64.getDecoder().decode(entity.getPictureUrl().split(",")[1]);
            if (!MyUtils.upFileToGoogleCloud("product_" + entity.getCode() + ".png", pictueBytes))
                return this.exceptionObject(new ProductEntity(), "Something's wrong when adding picture product");
        }

        entity.setPictureUrl("/file?name=" + "product_" + entity.getCode() + ".png");
        ProductEntity productEntity = productRepo.save(entity);
        productEntity.setMessage("Add product successfully");
        return productEntity;
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        ProductEntity productEntity = productRepo.findById(entity.getCode()).orElse(null);
        if (productEntity == null)
            return this.exceptionObject(new ProductEntity(), "This product does not exist");
        if (entity.getPictureUrl() == null && entity.getPictureUrl().trim().equals(""))
            return this.exceptionObject(new ProductEntity(), "Please add picture product");

        BeanUtils.copyProperties(entity, productEntity, getNullPropertyNames(entity));

        // up picture to cloud
        if (!entity.getPictureUrl().startsWith("http")  && !entity.getPictureUrl().contains("file?name=")) {
            byte[] pictueBytes = Base64.getDecoder().decode(entity.getPictureUrl().split(",")[1]);
            if (!MyUtils.upFileToGoogleCloud("product_" + productEntity.getCode() + ".png", pictueBytes))
                return this.exceptionObject(new ProductEntity(), "Something's wrong when adding picture product");
        }

        productEntity.setPictureUrl("/file?name=" + "product_" + productEntity.getCode() + ".png");
        productEntity = productRepo.save(productEntity);
        productEntity.setMessage("Update product successfully");
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
