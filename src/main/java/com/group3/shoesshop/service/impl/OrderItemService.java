package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.OrderItemDTO;
import com.group3.shoesshop.service.IOrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService extends BaseService<OrderItemDTO> implements IOrderItemService {
    @Override
    public List<OrderItemDTO> findAll() {
        return null;
    }

    @Override
    public OrderItemDTO save(OrderItemDTO dto) {
        return null;
    }

    @Override
    public OrderItemDTO update(OrderItemDTO dto) {
        return null;
    }

    @Override
    public OrderItemDTO findOne(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
