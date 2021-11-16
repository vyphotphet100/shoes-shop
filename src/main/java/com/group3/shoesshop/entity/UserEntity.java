package com.group3.shoesshop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active", columnDefinition = "BOOLEAN")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_code")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethodEntity paymentMethod;

    @OneToMany(mappedBy = "seller")
    private List<ProductEntity> products = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<TransferPaymentEntity> adminTransferPayments = new ArrayList<>();

    @OneToMany(mappedBy = "seller")
    private List<TransferPaymentEntity> sellerTransferPayments = new ArrayList<>();

}
