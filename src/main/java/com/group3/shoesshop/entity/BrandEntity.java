package com.group3.shoesshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
@Getter @Setter
public class BrandEntity extends BaseEntity<BrandEntity>{
    @Id
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<ProductEntity> products = new ArrayList<>();
}
