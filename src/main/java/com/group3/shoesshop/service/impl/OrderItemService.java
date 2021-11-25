package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.repository.OrderItemRepository;
import com.group3.shoesshop.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService extends BaseService<OrderItemEntity> implements IOrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepo;

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
        OrderItemEntity orderItemEntity = orderItemRepo.findById(id).orElse(null);
        if (orderItemEntity == null)
            return this.exceptionObject(new OrderItemEntity(), "This order item does not exist.");

        return orderItemEntity;
    }

    @Override
    public OrderItemEntity delete(Integer id) {
        OrderItemEntity orderItemEntity = orderItemRepo.findById(id).orElse(null);
        if (orderItemEntity == null)
            return this.exceptionObject(new OrderItemEntity(), "This order item does not exist.");

        orderItemRepo.delete(orderItemEntity);
        return orderItemEntity;
    }

    @Override
    public float getTotalCostOfOrderItemList(List<OrderItemEntity> orderItemEntities) {
        float res = 0;
        for (OrderItemEntity orderItemEntity: orderItemEntities)
            res += orderItemEntity.getTotalCost();

        return res;
    }

    @Override
    public OrderItemEntity updateQuantityBought(Integer orderItemId, Integer quantityBought) {
        OrderItemEntity orderItemEntity = orderItemRepo.findById(orderItemId).orElse(null);
        if (orderItemEntity == null)
            return this.exceptionObject(new OrderItemEntity(), "This order item does not exist.");

        orderItemEntity.setQuantityBought(quantityBought);
        orderItemEntity.setTotalCost(quantityBought*orderItemEntity.getProduct().getPrice());
        orderItemEntity = orderItemRepo.save(orderItemEntity);
        orderItemEntity.setMessage("Update quantity successfully.");
        return orderItemEntity;
    }
}
