package com.group3.shoesshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
        String[] tmp = ex.getClass().getName().split("\\.");
        String errorClassName = tmp[tmp.length-1];
        return new ErrorMessage(errorClassName, ex.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI());
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public ModelAndView handleAllException(Exception ex, WebRequest request) {
//        String[] tmp = ex.getClass().getName().split("\\.");
//        String errorClassName = tmp[tmp.length-1];
//
//        ModelAndView mav = new ModelAndView("Common_Page/404_Page/index");
//        return mav;
//    }
}
