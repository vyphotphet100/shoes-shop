package com.group3.shoesshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter @Setter
public class RoleEntity extends BaseEntity<RoleEntity>{
    @Id
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users = new ArrayList<>();

}
