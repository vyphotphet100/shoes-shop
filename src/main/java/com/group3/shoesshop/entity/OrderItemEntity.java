package com.group3.shoesshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItemEntity extends BaseEntity{

    @Id
    private Integer id;

    @Column(name = "quantity_bought")
    private Integer quantityBought;

    @Column(name = "total_cost")
    private Float totalCost;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserEntity customer;

    @ManyToOne
    @JoinColumn(name = "product_code")
    private ProductEntity product;

    @OneToOne(mappedBy = "orderItem")
    private PaymentEntity payment;

}
