package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IBaseService<ProductEntity>{

    ProductEntity findOne(String code);
    ProductEntity delete(String code);

//    List<ProductEntity> findAllWithPageable(Pageable pageable);
//    List<ProductEntity> findAllByIsAvailableWithKeyword(Boolean isAvailable, String keyword);
//    List<ProductEntity> findAllByAvailableAndSellerId(Boolean available, Integer id);
//    List<ProductEntity> findAllByAvailableAndSellerIdWithKeyword(Boolean available, Integer id, String keyword);
//    List<ProductEntity> findAllByIsAvailableAndCategoryCodeAndBrandCode(Boolean isAvailable, String categoryCode, String brandCode);
//    List<ProductEntity> findAllByCategoryCodeAndBrandCodeWithPageable(String categoryCode, String brandCode, Pageable pageable);
//    List<ProductEntity> findAllByCategoryCode(String categoryCode);
//    List<ProductEntity> findAllByCategoryCodeWithPageable(String categoryCode, Pageable pageable);
//    List<ProductEntity> findAllByBrandCodeWithPageable(String brandCode, Pageable pageable);
//    List<ProductEntity> findAllByCategoryCodeWithPageableAndKeyword(String categoryCode, Pageable pageable, String keyword);
//    List<ProductEntity> findAllWithPageableAndKeyword(Pageable pageable, String keyword);

    List<ProductEntity> filterByPrice(List<ProductEntity> productEntities, Integer lowest, Integer highest);



    List<ProductEntity> filterBySize(List<ProductEntity> productEntities, Integer lowest, Integer highest);

    Integer getSumOfQuantity();
    Integer getSumOfQuantity(Boolean isAvailable);

    //====================================================
    ProductEntity findOne(String code, Boolean isAvailable);

    List<ProductEntity> findAll(Pageable pageable);
    List<ProductEntity> findAll(String keyword);
    List<ProductEntity> findAll(Pageable pageable, String keyword);
    //(isAvailableMode)
    List<ProductEntity> findAll(Boolean isAvailable);
    List<ProductEntity> findAll(Pageable pageable, Boolean isAvailable);
    List<ProductEntity> findAll(String keyword, Boolean isAvailable);
    List<ProductEntity> findAll(Pageable pageable, String keyword, Boolean isAvailable);

    //By seller id
    List<ProductEntity> findAllBySellerId(Integer sellerId);
    List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable);
    List<ProductEntity> findAllBySellerId(Integer sellerId, String keyword);
    List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable, String keyword);
    // By seller id (isAvailableMode)
    List<ProductEntity> findAllBySellerId(Integer sellerId, Boolean isAvailable);
    List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable, Boolean isAvailable);
    List<ProductEntity> findAllBySellerId(Integer sellerId, String keyword, Boolean isAvailable);
    List<ProductEntity> findAllBySellerId(Integer sellerId, Pageable pageable, String keyword, Boolean isAvailable);


    // By category and brand code
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, String keyword);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable, String keyword);
    // By category and brand code (isAvailableMode)
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Boolean isAvailable);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable, Boolean isAvailable);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, String keyword, Boolean isAvailable);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode, Pageable pageable, String keyword, Boolean isAvailable);

    // By category code
    List<ProductEntity> findAllByCategoryCode(String categoryCode);
    List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable);
    List<ProductEntity> findAllByCategoryCode(String categoryCode, String keyword);
    List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable, String keyword);
    // By category code (isAvailableMode)
    List<ProductEntity> findAllByCategoryCode(String categoryCode, Boolean isAvailable);
    List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable, Boolean isAvailable);
    List<ProductEntity> findAllByCategoryCode(String categoryCode, String keyword, Boolean isAvailable);
    List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable, String keyword, Boolean isAvailable);

    // By brand code
    List<ProductEntity> findAllByBrandCode(String brandCode);
    List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable);
    List<ProductEntity> findAllByBrandCode(String brandCode, String keyword);
    List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable, String keyword);
    // By brand code (isAvailableMode)
    List<ProductEntity> findAllByBrandCode(String brandCode, Boolean isAvailable);
    List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable, Boolean isAvailable);
    List<ProductEntity> findAllByBrandCode(String brandCode, String keyword, Boolean isAvailable);
    List<ProductEntity> findAllByBrandCode(String brandCode, Pageable pageable, String keyword, Boolean isAvailable);

    // in stock
    List<ProductEntity> findAllInStock(Boolean inStock, Integer sellerId);
    List<ProductEntity> findAllInStock(Boolean inStock, Integer sellerId, Boolean isAvailable);

    List<ProductEntity> findAll(Pageable pageable, String categoryCode, String brandCode, String keyword, Integer priceMode, Integer sizeMode, Boolean isAvailable);
    List<ProductEntity> findAll(String categoryCode, String brandCode, String keyword, Integer priceMode, Integer sizeMode, Boolean isAvailable);
}
