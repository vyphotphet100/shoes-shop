package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.service.IOrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService extends BaseService<OrderItemEntity> implements IOrderItemService {
    @Override
    public List<OrderItemEntity> findAll() {
        return null;
    }

    @Override
    public OrderItemEntity save(OrderItemEntity entity) {
        return null;
    }

    @Override
    public OrderItemEntity update(OrderItemEntity entity) {
        return null;
    }

    @Override
    public OrderItemEntity findOne(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
