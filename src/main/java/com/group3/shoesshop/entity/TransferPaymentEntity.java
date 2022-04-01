package com.group3.shoesshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transfer_payment")
@Getter @Setter
public class TransferPaymentEntity extends BaseEntity<TransferPaymentEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transfer_date")
    private Date transferDate;

    @Column(name = "amount")
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private UserEntity admin;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentEntity payment;

}
