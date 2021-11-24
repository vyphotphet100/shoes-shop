package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IBaseService<ProductEntity>{
    ProductEntity findOne(String code);
    ProductEntity delete(String code);

    List<ProductEntity> findAllWithPageable(Pageable pageable);
    List<ProductEntity> findAllByAvailableAndSellerId(Boolean available, Integer id);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode);
    List<ProductEntity> findAllByCategoryCodeAndBrandCodeWithPageable(String categoryCode, String brandCode, Pageable pageable);
    List<ProductEntity> findAllByCategoryCode(String categoryCode);
    List<ProductEntity> findAllByCategoryCodeWithPageable(String categoryCode, Pageable pageable);
    List<ProductEntity> filterByPrice(List<ProductEntity> productEntities, Integer lowest, Integer highest);
    List<ProductEntity> filterBySize(List<ProductEntity> productEntities, Integer lowest, Integer highest);
}
