package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.OrderItemEntity;

import java.util.List;

public interface IOrderItemService extends IBaseService<OrderItemEntity>{
    OrderItemEntity findOne(Integer id);
    OrderItemEntity delete(Integer id);

    float getTotalCostOfOrderItemList(List<OrderItemEntity> orderItemEntities);
    OrderItemEntity updateQuantityBought(Integer orderItemId, Integer quantityBought);
    float getTotalCostOfOrdered();
    float getTotalCostOfOrderedBySellerId(Integer sellerId);

    float getAverageCost();
    float getAverageCostBySellerId(Integer sellerId);
    Integer getTotalOrdered();
    Integer getTotalOrderedBySellerId(Integer sellerId);

    List<OrderItemEntity> findAllByCustomerIdAndSellerId(Integer customerId, Integer sellerId);
}
