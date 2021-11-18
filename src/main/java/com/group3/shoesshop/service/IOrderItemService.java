package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.OrderItemEntity;

import java.util.List;

public interface IOrderItemService extends IBaseService<OrderItemEntity>{
    OrderItemEntity findOne(Integer id);
    OrderItemEntity delete(Integer id);

    float getTotalCostOfOrderItemList(List<OrderItemEntity> orderItemEntities);
}
