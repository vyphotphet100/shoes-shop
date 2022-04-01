package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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
    List<ProductEntity> findAllBySellerIdAndInStock(Integer sellerId, Boolean inStock);
    List<ProductEntity> findAllBySellerIdAndInStockAndIsAvailable(Integer sellerId, Boolean inStock, Boolean isAvailable);

    // available
    List<ProductEntity> findAllByIsAvailableAndCategoryCodeAndBrandCode(Boolean isAvailable, String categoryCode, String brandCode);

    // search
    @Query(value = "SELECT p FROM ProductEntity p WHERE " +
            "p.title like %:keyword%")
    List<ProductEntity> findAllByWithKeyword(String keyword);
    List<ProductEntity> findAllByTitleContaining(Pageable pageable, String keyword);

    @Query(value = "SELECT p FROM ProductEntity p WHERE " +
            "p.isAvailable = :isAvailable AND p.title like %:keyword%")
    List<ProductEntity> findAllByIsAvailableWithKeyword(Boolean isAvailable, String keyword);

    @Query(value = "SELECT p FROM ProductEntity p WHERE " +
            "p.category.code = :categoryCode AND " +
            "p.title like %:keyword%")
    List<ProductEntity> findAllByCategoryCodeWithKeyword(String categoryCode, String keyword);

    @Query(value = "SELECT SUM(p.quantity) FROM ProductEntity p WHERE p.isAvailable = :isAvailable")
    Integer getSumOfQuantity(Boolean isAvailable);

    @Query(value = "SELECT SUM(p.quantity) FROM ProductEntity p")
    Integer getSumOfQuantity();

}
