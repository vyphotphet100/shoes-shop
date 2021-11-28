package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return productRepo.findAllByIsAvailable( true);
    }

    @Override
    public List<ProductEntity> findAllWithPageable(Pageable pageable) {
        return productRepo.findAllByIsAvailable(pageable, true);
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
        String fileName = "product_" + productEntity.getCode() + ".png";
        if (!entity.getPictureUrl().startsWith("http")  && !entity.getPictureUrl().contains("file?name=")) {
            byte[] pictueBytes = Base64.getDecoder().decode(entity.getPictureUrl().split(",")[1]);
            if (!MyUtils.upFileToGoogleCloud(fileName, pictueBytes))
                return this.exceptionObject(new ProductEntity(), "Something's wrong when adding picture product");
            MyUtils.getFileFromGoogleCloud(fileName);
        }

        productEntity.setPictureUrl("/file?name=" + fileName);
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

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<ProductEntity> findAllByAvailableAndSellerId(Boolean available, Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElse(null);
        if (userEntity == null)
            return null;

        List<ProductEntity> res = new ArrayList<>();
        for (ProductEntity productEntity: userEntity.getProducts()) {
            if (productEntity.getIsAvailable().equals(available))
                res.add(productEntity);
        }

        return res;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode) {
        return productRepo.findAllByCategoryCodeAndBrandCode(categoryCode, brandCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCodeWithPageable(String categoryCode, String brandCode, Pageable pageable) {
        return productRepo.findAllByCategoryCodeAndBrandCode(pageable, categoryCode, brandCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode) {
        return productRepo.findAllByCategoryCode(categoryCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeWithPageable(String categoryCode, Pageable pageable) {
        return productRepo.findAllByCategoryCode(pageable, categoryCode);
    }

    @Override
    public List<ProductEntity> findAllByBrandCodeWithPageable(String brandCode, Pageable pageable) {
        return productRepo.findAllByBrandCode(pageable, brandCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeWithPageableAndKeyword(String categoryCode, Pageable pageable, String keyword) {
        return productRepo.findAllByCategoryCodeWithKeyword(categoryCode, keyword);
    }

    @Override
    public List<ProductEntity> findAllWithPageableAndKeyword(Pageable pageable, String keyword) {
        return productRepo.findAllByWithKeyword(keyword);
    }

    @Override
    public List<ProductEntity> filterByPrice(List<ProductEntity> productEntities, Integer lowest, Integer highest) {
        List<ProductEntity> resEntities = new ArrayList<>();
        for (ProductEntity productEntity: productEntities) {
            if (productEntity.getPrice() >= lowest &&
                    productEntity.getPrice() <= highest)
                resEntities.add(productEntity);
        }

        return resEntities;
    }

    @Override
    public List<ProductEntity> filterBySize(List<ProductEntity> productEntities, Integer lowest, Integer highest) {
        List<ProductEntity> resEntities = new ArrayList<>();
        for (ProductEntity productEntity: productEntities) {
            if (productEntity.getSize() >= lowest &&
                    productEntity.getSize() <= highest)
                resEntities.add(productEntity);
        }

        return resEntities;
    }

    @Override
    public Integer getTotalQuantity() {
        Integer totalQuantity = 0;
        List<ProductEntity> productEntities = productRepo.findAll();
        for (ProductEntity productEntity: productEntities) {
            totalQuantity += productEntity.getQuantity();
        }

        return totalQuantity;
    }

    @Override
    public List<ProductEntity> findAllInStockProductBySellerId(Integer sellerId) {
        List<ProductEntity> productEntities = this.findAllByAvailableAndSellerId(true, sellerId);
        List<ProductEntity> resEntities = new ArrayList<>();
        for (ProductEntity productEntity: productEntities) {
            if (productEntity.getInStock().equals(true))
                resEntities.add(productEntity);
        }

        return resEntities;
    }
}
