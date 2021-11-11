package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.UserEntity;

import java.util.List;

public interface IUserService extends IBaseService<UserEntity>{
    UserEntity findOne(Integer id);
    void delete(Integer id);

    UserEntity findByUsernameAndPassword(String username, String password);
    List<UserEntity> findAllSeller();
    List<UserEntity> findAllBuyer();

    Integer getOrderedItem(Integer customerId);
    float getTotalSpent(Integer customerId);

}
