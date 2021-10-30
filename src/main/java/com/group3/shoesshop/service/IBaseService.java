package com.group3.shoesshop.service;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();
}
