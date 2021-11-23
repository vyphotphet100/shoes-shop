package com.group3.shoesshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class UserDTO extends BaseDTO{
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String address;
    private String phone;
    private String email;
    private String username;
    private String password;
    private Boolean isActive;
    private String roleCode;
    private Integer paymentMethodId;
    private List<String> productCodes = new ArrayList<>();
    private List<Integer> orderItemIds = new ArrayList<>();
    private List<Integer> adminTransferPaymentIds = new ArrayList<>();
    private List<Integer> sellerTransferPaymentIds = new ArrayList<>();


    ////
    private String oldPassword;
    private String confirmPassword;
}
