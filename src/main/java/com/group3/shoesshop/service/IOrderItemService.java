package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.OrderItemDTO;

public interface IOrderItemService extends IBaseService<OrderItemDTO>{
    OrderItemDTO findOne(Integer id);
    void delete(Integer id);
}
