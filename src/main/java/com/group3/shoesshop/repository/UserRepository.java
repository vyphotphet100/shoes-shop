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
    List<UserEntity> findAllByIsActive(Boolean isActive);

    List<UserEntity> findAllByIsActiveAndRoleCode(Boolean isActive, String roleCode);

    @Query(value = "SELECT u FROM UserEntity u WHERE " +
            "u.role.code = 'BUYER' AND " +
            "u.isActive = :isActive AND " +
            "(u.firstName like %:keyword% OR " +
            "u.lastName like %:keyword% OR " +
            "CONCAT(CONCAT(u.firstName, ' '), u.lastName) like %:keyword%)")
    List<UserEntity> findAllBuyerByIsActiveAndKeyword(Boolean isActive, @Param("keyword") String keyword);

    @Query(value = "SELECT u FROM UserEntity u WHERE " +
            "u.role.code = 'SELLER' AND " +
            "(u.firstName like %:keyword% OR " +
            "u.lastName like %:keyword% OR " +
            "CONCAT(u.id, '') like %:keyword% OR " +
            "CONCAT(CONCAT(u.firstName, ' '), u.lastName) like %:keyword%)")
    List<UserEntity> findAllSellerByKeyword(@Param("keyword") String keyword);

    UserEntity findOneByIsActiveAndId(Boolean isActive, Integer id);
}
