package com.group3.shoesshop.exception;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ErrorMessage {
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private String error;
    private String message;
    private String path;

    public ErrorMessage(String error, String message, String path) {
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
