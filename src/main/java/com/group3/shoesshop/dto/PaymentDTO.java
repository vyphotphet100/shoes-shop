package com.group3.shoesshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class PaymentDTO extends BaseDTO{
    private Integer id;
    private Date paymentDate;
    private Date shipmentDate;
    private Integer orderItemId;
    private Integer transferPaymentId;
}
