package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.converter.dto_entity.mapper.UserMapper;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.service.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService<UserEntity> implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        UserEntity userEntity = userRepo.findByUsername(entity.getUsername());
        if (userEntity != null)
            return this.exceptionObject(new UserEntity(), "This username exists.");

        entity.setIsActive(true);
        entity = userRepo.save(entity);
        entity.setMessage("Register account successfully.");
        return entity;
    }

    @Override
    public UserEntity update(UserEntity entity) {
        UserEntity userEntity = userRepo.findById(entity.getId()).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "This user id does not exist.");

        BeanUtils.copyProperties(entity, userEntity, getNullPropertyNames(entity));

        userEntity = userRepo.save(userEntity);
        userEntity.setMessage("Update information successfully.");
        return userEntity;
    }

    @Override
    public UserEntity findOne(Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "This user id does not exist.");

        return userEntity;
    }

    @Override
    public UserEntity delete(Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "This user does not exist");

        userEntity.setIsActive(false);
        userEntity = this.update(userEntity);
        userEntity.setMessage("Delete user successfully");
        return userEntity;
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepo.findByUsernameAndPassword(username, password);

        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "Invalid username or password.");

        userEntity.setMessage("Log in successfully.");
        return userEntity;
    }

    @Override
    public List<UserEntity> findAllSeller() {
        return userRepo.findAllByRoleCodeAndIsActive("SELLER", true);
    }

    @Override
    public List<UserEntity> findAllSellerByKeyword(String keyword) {
        return userRepo.findAllSellerByKeyword(keyword);
    }

    @Override
    public List<UserEntity> findAllBuyer() {
        return userRepo.findAllByRoleCodeAndIsActive("BUYER", true);
    }

    @Override
    public List<UserEntity> findAllBuyerByKeyword(String keyword) {
//        List<UserEntity> res = new ArrayList<>();
//        for (String subKey: keyword.split(" ")) {
//            List<UserEntity> userEntities = userRepo.findAllBuyerByKeyword(subKey);
//            for (UserEntity userEntity: userEntities)
//                if (!res.contains(userEntity))
//                    res.add(userEntity);
//        }

        return userRepo.findAllBuyerByKeyword(keyword);
    }

    @Override
    public Integer getOrderedItem(Integer customerId) {
        UserEntity customer = userRepo.findById(customerId).orElse(null);

        Integer ordered = 0;
        for (OrderItemEntity orderItem: customer.getOrderItems())
            ordered += orderItem.getQuantityBought();

        return ordered;
    }

    @Override
    public float getTotalSpent(Integer customerId) {
        UserEntity customer = userRepo.findById(customerId).orElse(null);

        float totalSpent=0;
        for (OrderItemEntity orderItem: customer.getOrderItems())
            totalSpent += orderItem.getTotalCost();

        return totalSpent;
    }

}
