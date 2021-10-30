package com.group3.shoesshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class TransferPaymentDTO extends BaseDTO{
    private Integer id;
    private Date transferDate;
    private Float amount;
    private Integer adminId;
    private Integer sellerId;
    private Integer paymentId;
}
