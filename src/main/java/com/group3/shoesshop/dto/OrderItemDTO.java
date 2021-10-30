package com.group3.shoesshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO extends BaseDTO {
    private Integer id;
    private Integer quantityBought;
    private Float totalCost;
    private Integer customerId;
    private String productCode;
    private Integer paymentId;
}
