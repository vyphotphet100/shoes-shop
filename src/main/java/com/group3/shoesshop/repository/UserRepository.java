package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByUsername(String username);
    List<UserEntity> findAllByRoleCode(String roleCode);
}
