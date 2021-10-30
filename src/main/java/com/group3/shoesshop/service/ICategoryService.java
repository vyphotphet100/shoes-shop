package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.CategoryDTO;

public interface ICategoryService extends IBaseService<CategoryDTO>{
    CategoryDTO findOne(String code);
    void delete(String code);
}
