package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
    List<PaymentEntity> findAllByOrderItemProductSellerId(Integer sellerId);
}
