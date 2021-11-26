package com.group3.shoesshop.utils;

import com.group3.shoesshop.entity.OrderItemEntity;

import java.util.List;

public class PaymentUtils {
    public static String generateDescriptionFromOrderItemList(List<OrderItemEntity> orderItemEntities) {
        String description = "This payment is for:";
        for (OrderItemEntity orderItemEntity : orderItemEntities) {
            if (!orderItemEntity.equals(orderItemEntities.get(orderItemEntities.size() - 1)))
                description += " " + orderItemEntity.getProduct().getTitle() + ",";
            else
                description += " " + orderItemEntity.getProduct().getTitle() + ".";
        }

        return description;
    }

    public static float getTotalCostOfOrderItemList(List<OrderItemEntity> orderItemEntities) {
        float total = 0;
        for (OrderItemEntity orderItemEntity : orderItemEntities)
            total += orderItemEntity.getProduct().getPrice() * orderItemEntity.getQuantityBought();

        return total;
    }
}
