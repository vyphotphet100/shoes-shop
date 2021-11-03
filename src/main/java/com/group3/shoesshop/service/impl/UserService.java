package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.converter.dto_entity.mapper.UserMapper;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        userEntity = userRepo.save(userEntity);
        userEntity.setMessage("Register account successfully.");
        return userEntity;
    }

    @Override
    public UserEntity update(UserEntity entity) {
        UserEntity userEntity = userRepo.findById(entity.getId()).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "This user id does not exist.");

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
    public void delete(Integer id) {

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
        return userRepo.findAllByRoleCode("SELLER");
    }

    @Override
    public List<UserEntity> findAllBuyer() {
        return userRepo.findAllByRoleCode("BUYER");
    }
}
