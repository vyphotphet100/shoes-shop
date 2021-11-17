package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);

    List<UserEntity> findAllByRoleCode(String roleCode);

    List<UserEntity> findAllByRoleCodeAndIsActive(String roleCode, Boolean isActive);

    @Query(value = "SELECT u FROM UserEntity u WHERE " +
            "u.role.code = 'BUYER' AND " +
            "(u.firstName like %:keyword% OR " +
            "u.lastName like %:keyword% OR " +
            "CONCAT(u.id, '') like %:keyword%)")
    List<UserEntity> findAllBuyerByKeyword(@Param("keyword") String keyword);

    @Query(value = "SELECT u FROM UserEntity u WHERE " +
            "u.role.code = 'SELLER' AND " +
            "(u.firstName like %:keyword% OR " +
            "u.lastName like %:keyword% OR " +
            "CONCAT(u.id, '') like %:keyword%)")
    List<UserEntity> findAllSellerByKeyword(@Param("keyword") String keyword);
}
