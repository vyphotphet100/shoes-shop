package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    List<ProductEntity> findAllByIsAvailable(Pageable pageable, Boolean isAvailable);
    List<ProductEntity> findAllByIsAvailable(Boolean isAvailable);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(String categoryCode, String brandCode);
    List<ProductEntity> findAllByCategoryCodeAndBrandCode(Pageable pageable, String categoryCode, String brandCode);
    List<ProductEntity> findAllByCategoryCode(String categoryCode);
    List<ProductEntity> findAllByCategoryCode(Pageable pageable, String categoryCode);
    List<ProductEntity> findAllByBrandCode(Pageable pageable, String brandCode);

    // search
    @Query(value = "SELECT p FROM ProductEntity p WHERE " +
            "p.title like %:keyword%")
    List<ProductEntity> findAllByWithKeyword(String keyword);

    @Query(value = "SELECT p FROM ProductEntity p WHERE " +
            "p.category.code = :categoryCode AND " +
            "p.title like %:keyword%")
    List<ProductEntity> findAllByCategoryCodeWithKeyword(String categoryCode, String keyword);
}
