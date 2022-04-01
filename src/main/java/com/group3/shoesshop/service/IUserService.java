package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.impl.UserService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService extends IBaseService<UserEntity>{
    UserEntity findOneByIsActiveAndId(Boolean isActive, Integer id);
    UserEntity delete(Integer id);

    UserEntity findByUsernameAndPassword(String username, String password);
    List<UserEntity> findAllSellerByIsActive(Boolean isActive);
    List<UserEntity> findAllSellerByKeyword(String keyword);
    List<UserEntity> findAllBuyerByIsActive(Boolean isActive);
    List<UserEntity> findAllBuyerByIsActiveAndKeyword(Boolean isAvailable, String keyword);

    Integer getOrderedItem(Integer customerId);
    float getTotalSpent(Integer customerId);
    UserEntity addProductToCart(Integer userId, String productCode,Integer quantityBought);
    List<OrderItemEntity> getOrderItemsWithoutPayment(Integer userId); // order items in shopping cart

    List<UserEntity> findAllCustomerBySellerId(Integer sellerId);

    //=========================================================
    UserEntity findOne(Integer id);
    UserEntity findOne(Integer id, UserService.IsActiveMode isActiveMode);


    List<UserEntity> findAll(Pageable pageable);
    List<UserEntity> findAll(String keyword);
    List<UserEntity> findAll(Pageable pageable, String keyword);
    // (isActiveMode)
    List<UserEntity> findAll(UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAll(Pageable pageable, UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAll(String keyword, UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAll(Pageable pageable, String keyword, UserService.IsActiveMode isActiveMode);

    // seller
    List<UserEntity> findAllSeller();
    List<UserEntity> findAllSeller(Pageable pageable);
    List<UserEntity> findAllSeller(String keyword);
    List<UserEntity> findAllSeller(Pageable pageable, String keyword);
    // seller (isActiveMode)
    List<UserEntity> findAllSeller(UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAllSeller(Pageable pageable, UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAllSeller(String keyword, UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAllSeller(Pageable pageable, String keyword, UserService.IsActiveMode isActiveMode);

    // buyer
    List<UserEntity> findAllBuyer();
    List<UserEntity> findAllBuyer(Pageable pageable);
    List<UserEntity> findAllBuyer(String keyword);
    List<UserEntity> findAllBuyer(Pageable pageable, String keyword);
    // buyer (isActiveMode)
    List<UserEntity> findAllBuyer(UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAllBuyer(Pageable pageable, UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAllBuyer(String keyword, UserService.IsActiveMode isActiveMode);
    List<UserEntity> findAllBuyer(Pageable pageable, String keyword, UserService.IsActiveMode isActiveMode);

}
