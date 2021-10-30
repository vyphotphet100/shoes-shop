package com.group3.shoesshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RoleDTO extends BaseDTO {
    private String code;
    private String name;
    private List<Integer> userIds = new ArrayList<>();
}
