package com.group3.shoesshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter @Setter
public class ProductEntity extends BaseEntity<ProductEntity>{

    @Id
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "size")
    private Integer size;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "in_stock")
    private Boolean inStock;

    @Column(name = "picture_url", columnDefinition = "TEXT")
    private String pictureUrl;

    @Column(name = "is_available", columnDefinition = "BOOLEAN")
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

    @ManyToOne
    @JoinColumn(name = "category_code")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "brand_code")
    private BrandEntity brand;

    @OneToMany(mappedBy = "product")
    private List<OrderItemEntity> orderItems = new ArrayList<>();
}
