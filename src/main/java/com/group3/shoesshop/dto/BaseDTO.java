package com.group3.shoesshop.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
public abstract class BaseDTO {
    private String createdBy;
    private Date createDate;
    private String modifiedBy;
    private Date modifiedDate;

    private List<Object> listResult = new ArrayList<>();
    private String message;
    private HttpStatus httpStatus = HttpStatus.OK;
    private List<Object> listRequest = new ArrayList<>();
}
