package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.OrderItemEntity;

public interface IOrderItemService extends IBaseService<OrderItemEntity>{
    OrderItemEntity findOne(Integer id);
    void delete(Integer id);
}
