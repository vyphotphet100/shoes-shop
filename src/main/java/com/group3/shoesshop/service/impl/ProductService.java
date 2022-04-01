package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProductService extends BaseService<ProductEntity> implements IProductService {
//    public enum IsAvailableMode {
//        TRUE,
//        FALSE,
//        BOTH
//    }

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<ProductEntity> findAll() {
        return productRepo.findAll();
    }

//    @Override
//    public List<ProductEntity> findAllWithPageable(Pageable pageable) {
//        return productRepo.findAllByIsAvailable(pageable, true);
//    }

//    @Override
//    public List<ProductEntity> findAllByIsAvailableWithKeyword(Boolean isAvailable, String keyword) {
////        List<ProductEntity> productEntities = productRepo.findAllByIsAvailable(true);
////        List<ProductEntity> resEntities = new ArrayList<>();
////        for (ProductEntity productEntity: productEntities)
////            if (productEntity.getTitle().toLowerCase().contains(keyword.toLowerCase()))
////                resEntities.add(productEntity);
//
//        List<ProductEntity> resEntities = productRepo.findAllByIsAvailableWithKeyword(isAvailable, keyword);
//
//        return resEntities;
//    }

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
        if (!entity.getPictureUrl().startsWith("http") && !entity.getPictureUrl().contains("file?name=")) {
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

//    @Override
//    public List<ProductEntity> findAllByAvailableAndSellerId(Boolean available, Integer id) {
//        UserEntity userEntity = userRepo.findById(id).orElse(null);
//        if (userEntity == null)
//            return null;
//
//        List<ProductEntity> res = new ArrayList<>();
//        for (ProductEntity productEntity : userEntity.getProducts()) {
//            if (productEntity.getIsAvailable().equals(available))
//                res.add(productEntity);
//        }
//
//        return res;
//    }

//    @Override
//    public List<ProductEntity> findAllByAvailableAndSellerIdWithKeyword(Boolean available, Integer id, String keyword) {
//        List<ProductEntity> productEntities = this.findAllBySellerId(id, IsAvailableMode.TRUE);
//        List<ProductEntity> resEntities = new ArrayList<>();
//        for (ProductEntity productEntity : productEntities)
//            if (productEntity.getTitle().toLowerCase().contains(keyword.toLowerCase()))
//                resEntities.add(productEntity);
//
//        return resEntities;
//    }

//    @Override
//    public List<ProductEntity> findAllByIsAvailableAndCategoryCodeAndBrandCode(Boolean isAvailable, String categoryCode, String brandCode) {
//        return productRepo.findAllByIsAvailableAndCategoryCodeAndBrandCode(isAvailable, categoryCode, brandCode);
//    }

//    @Override
//    public List<ProductEntity> findAllByCategoryCodeAndBrandCodeWithPageable(String categoryCode, String brandCode, Pageable pageable) {
//        return this.getProductByIsAvailable(productRepo.findAllByCategoryCodeAndBrandCode(pageable, categoryCode, brandCode), true);
//    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode) {
        return this.getProductByIsAvailable(productRepo.findAllByCategoryCode(categoryCode), true);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable) {
        return productRepo.findAllByCategoryCode(pageable, categoryCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode, String keyword) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable, String keyword) {
        return productRepo.findAllByCategoryCodeWithKeyword(categoryCode, keyword);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable, Boolean isAvailable) {
        return this.getProductByIsAvailable(productRepo.findAllByCategoryCode(pageable, categoryCode), isAvailable);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode, String keyword, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable, String keyword, Boolean isAvailable) {
        return this.getProductByIsAvailable(productRepo.findAllByCategoryCodeWithKeyword(categoryCode, keyword), isAvailable);
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable) {
        return productRepo.findAllByBrandCode(pageable, brandCode);
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode, String keyword) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable, Boolean isAvailable) {
        return this.getProductByIsAvailable(productRepo.findAllByBrandCode(pageable, brandCode), isAvailable);
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode, String keyword, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable, String keyword, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAll(Pageable pageable, String categoryCode, String brandCode, String keyword, Integer priceMode, Integer sizeMode, Boolean isAvailable) {
        String query = "SELECT * FROM product WHERE ";

        if (categoryCode != null)
            query += "category_code = '" + categoryCode + "' AND ";
        if (brandCode != null)
            query += "brand_code = '" + brandCode + "' AND ";
        if (keyword != null)
            query += "title like '%" + keyword + "%' AND ";
        if (priceMode != null) {
            if (priceMode == 1)
                query += "price >= 50 AND price <= 200 AND ";
            else if (priceMode == 2)
                query += "price >= 200 AND price <= 500 AND ";
            else if (priceMode == 3)
                query += "price >= 500 AND price <= 999999999 AND ";
        }

        if (sizeMode != null) {
            if (sizeMode == 1)
                query += "size >= 36 AND size <= 40 AND ";
            else if (sizeMode == 2)
                query += "size >= 40 AND size <= 42 AND ";
            else if (sizeMode == 3)
                query += "size >= 42 AND size <= 9999 AND ";
        }

        if (isAvailable != null)
            query += "is_available = " + isAvailable.toString() + " AND ";

        if (query.endsWith("AND ")) {
            query = query.substring(0, query.length() - 4);
        } else if (query.endsWith("WHERE ")) {
            query = query.substring(0, query.length() - 6);
        }

        query += "LIMIT " + pageable.getOffset() + "," + pageable.getPageSize();
        System.out.println(query);

        return this.createNativeQuery(query, ProductEntity.class).getResultList();
    }

    @Override
    public List<ProductEntity> findAll(String categoryCode, String brandCode, String keyword, Integer priceMode, Integer sizeMode, Boolean isAvailable) {
        String query = "SELECT * FROM product WHERE ";

        if (categoryCode != null)
            query += "category_code = '" + categoryCode + "' AND ";
        if (brandCode != null)
            query += "brand_code = '" + brandCode + "' AND ";
        if (keyword != null)
            query += "title like '%" + keyword + "%' AND ";
        if (priceMode != null) {
            if (priceMode == 1)
                query += "price >= 50 AND price <= 200 AND ";
            else if (priceMode == 2)
                query += "price >= 200 AND price <= 500 AND ";
            else if (priceMode == 3)
                query += "price >= 500 AND price <= 999999999 AND ";
        }

        if (sizeMode != null) {
            if (sizeMode == 1)
                query += "size >= 36 AND size <= 40 AND ";
            else if (sizeMode == 2)
                query += "size >= 40 AND size <= 42 AND ";
            else if (sizeMode == 3)
                query += "size >= 42 AND size <= 9999 AND ";
        }

        if (isAvailable != null)
            query += "is_available = " + isAvailable.toString() + " AND ";

        if (query.endsWith("AND ")) {
            query = query.substring(0, query.length() - 4);
        } else if (query.endsWith("WHERE ")) {
            query = query.substring(0, query.length() - 6);
        }

        System.out.println(query);

//        List<ProductEntity> productEntities = new ArrayList<>();
//        for (Object obj: this.createNativeQuery(query, ProductEntity.class).getResultList()) {
//            productEntities.add((ProductEntity) obj);
//        }


        return this.createNativeQuery(query, ProductEntity.class).getResultList();
    }

//    @Override
//    public List<ProductEntity> findAllByCategoryCodeWithPageable(String categoryCode, Pageable pageable) {
//        return this.getProductByIsAvailable(productRepo.findAllByCategoryCode(pageable, categoryCode), true);
//    }

//    @Override
//    public List<ProductEntity> findAllByBrandCodeWithPageable(String brandCode, Pageable pageable) {
//        return this.getProductByIsAvailable(productRepo.findAllByBrandCode(pageable, brandCode), true);
//    }

//    @Override
//    public List<ProductEntity> findAllByCategoryCodeWithPageableAndKeyword(String categoryCode, Pageable pageable, String keyword) {
//        return this.getProductByIsAvailable(productRepo.findAllByCategoryCodeWithKeyword(categoryCode, keyword), true);
//    }

//    @Override
//    public List<ProductEntity> findAllWithPageableAndKeyword(Pageable pageable, String keyword) {
//        return this.getProductByIsAvailable(productRepo.findAllByWithKeyword(keyword), true);
//    }

    @Override
    public List<ProductEntity> filterByPrice(List<ProductEntity> productEntities, Integer lowest, Integer highest) {
//        List<ProductEntity> resEntities = new ArrayList<>();
//        for (ProductEntity productEntity : productEntities) {
//            if (productEntity.getPrice() >= lowest &&
//                    productEntity.getPrice() <= highest)
//                resEntities.add(productEntity);
//        }
//
//        return this.getProductByIsAvailable(resEntities, true);

//        return productRepo.findAllByPriceGreaterThanEqualAndPriceLessThanEqualAndIsAvailable(Float.valueOf(lowest), Float.valueOf(highest), true);
        return null;
    }

    @Override
    public List<ProductEntity> filterBySize(List<ProductEntity> productEntities, Integer lowest, Integer highest) {
        List<ProductEntity> resEntities = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            if (productEntity.getSize() != null &&
                    productEntity.getSize() >= lowest &&
                    productEntity.getSize() <= highest)
                resEntities.add(productEntity);
        }

        return this.getProductByIsAvailable(resEntities, true);
    }

    @Override
    public Integer getSumOfQuantity() {
//        Integer totalQuantity = 0;
//        List<ProductEntity> productEntities = productRepo.findAllByIsAvailable(true);
//        for (ProductEntity productEntity : productEntities) {
//            if (productEntity.getQuantity() != null)
//                totalQuantity += productEntity.getQuantity();
//        }
//
//        return totalQuantity;

        return productRepo.getSumOfQuantity();
    }

    @Override
    public Integer getSumOfQuantity(Boolean isAvailable) {
        return productRepo.getSumOfQuantity(isAvailable);
    }

//    @Override
//    public List<ProductEntity> findAllInStockProductBySellerId(Integer sellerId) {
//        List<ProductEntity> productEntities = this.findAllBySellerId(sellerId, true);
//        List<ProductEntity> resEntities = new ArrayList<>();
//        for (ProductEntity productEntity : productEntities) {
//            if (productEntity.getInStock().equals(true))
//                resEntities.add(productEntity);
//        }
//
//        return this.getProductByIsAvailable(resEntities, true);
//    }

    @Override
    public List<ProductEntity> findAllInStock(Boolean inStock, Integer sellerId) {
        return productRepo.findAllBySellerIdAndInStock(sellerId, inStock);
    }

    @Override
    public List<ProductEntity> findAllInStock(Boolean inStock, Integer sellerId, Boolean isAvailable) {
        return productRepo.findAllBySellerIdAndInStockAndIsAvailable(sellerId, inStock, isAvailable);
    }

    @Override
    public ProductEntity findOne(String code, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAll(Pageable pageable) {
        return productRepo.findAll(pageable).toList();
    }

    @Override
    public List<ProductEntity> findAll(String keyword) {
        return productRepo.findAllByWithKeyword(keyword);
    }

    @Override
    public List<ProductEntity> findAll(Pageable pageable, String keyword) {
        return productRepo.findAllByTitleContaining(pageable, keyword);
    }

    @Override
    public List<ProductEntity> findAll(Boolean isAvailable) {
        return productRepo.findAllByIsAvailable(isAvailable);
    }

    @Override
    public List<ProductEntity> findAll(Pageable pageable, Boolean isAvailable) {
        return productRepo.findAllByIsAvailable(pageable, isAvailable);

    }

    @Override
    public List<ProductEntity> findAll(String keyword, Boolean isAvailable) {
        return productRepo.findAllByIsAvailableWithKeyword(isAvailable, keyword);
    }

    @Override
    public List<ProductEntity> findAll(Pageable pageable, String keyword, Boolean isAvailable) {
        return this.getProductByIsAvailable(productRepo.findAllByTitleContaining(pageable, keyword), isAvailable);
    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId) {
        UserEntity userEntity = userRepo.findById(sellerId).orElse(null);
        if (userEntity == null)
            return null;

        return userEntity.getProducts();

    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId, String keyword) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId, Boolean isAvailable) {
        UserEntity userEntity = userRepo.findById(sellerId).orElse(null);
        if (userEntity == null)
            return null;

        List<ProductEntity> res = new ArrayList<>();
        for (ProductEntity productEntity : userEntity.getProducts()) {
            if (productEntity.getIsAvailable().equals(isAvailable))
                res.add(productEntity);
        }

        return res;
    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId, String keyword, Boolean isAvailable) {
        List<ProductEntity> productEntities = this.findAllBySellerId(sellerId, isAvailable);
        List<ProductEntity> resEntities = new ArrayList<>();
        for (ProductEntity productEntity : productEntities)
            if (productEntity.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                resEntities.add(productEntity);

        return resEntities;
    }

    @Override
    public List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable, String keyword, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode) {
        return productRepo.findAllByCategoryCodeAndBrandCode(categoryCode, brandCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable) {
        return productRepo.findAllByCategoryCodeAndBrandCode(pageable, categoryCode, brandCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, String keyword) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Boolean isAvailable) {
        return productRepo.findAllByIsAvailableAndCategoryCodeAndBrandCode(isAvailable, categoryCode, brandCode);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable, Boolean isAvailable) {
        return this.getProductByIsAvailable(productRepo.findAllByCategoryCodeAndBrandCode(pageable, categoryCode, brandCode), isAvailable);
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, String keyword, Boolean isAvailable) {
        return null;
    }

    @Override
    public List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable, String keyword, Boolean isAvailable) {
        return null;
    }
}
