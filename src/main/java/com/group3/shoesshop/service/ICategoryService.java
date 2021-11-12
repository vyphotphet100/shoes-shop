package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.CategoryEntity;

public interface ICategoryService extends IBaseService<CategoryEntity>{
    CategoryEntity findOne(String code);
    CategoryEntity delete(String code);
}
