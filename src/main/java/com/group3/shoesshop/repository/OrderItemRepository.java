package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
    List<OrderItemEntity> findAllByCustomerIdAndProductSellerId(Integer customerId, Integer sellerId);
}
