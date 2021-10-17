package com.group3.shoesshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter @Setter
public class PaymentEntity extends BaseEntity{

    @Id
    private Integer id;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "shipment_date")
    private Date shipmentDate;

    @OneToOne
    @JoinColumn(name = "order_item_id", referencedColumnName = "id")
    private OrderItemEntity orderItem;

    @OneToOne(mappedBy = "payment")
    private TransferPaymentEntity transferPayment;

}
