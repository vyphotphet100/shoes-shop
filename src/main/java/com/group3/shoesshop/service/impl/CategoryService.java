package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.CategoryEntity;
import com.group3.shoesshop.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<CategoryEntity> implements ICategoryService {
    @Override
    public List<CategoryEntity> findAll() {
        return null;
    }

    @Override
    public CategoryEntity save(CategoryEntity entity) {
        return null;
    }

    @Override
    public CategoryEntity update(CategoryEntity entity) {
        return null;
    }

    @Override
    public CategoryEntity findOne(String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}
