package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.CategoryEntity;
import com.group3.shoesshop.repository.CategoryRepository;
import com.group3.shoesshop.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<CategoryEntity> implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepo.findAll();
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
        return categoryRepo.findById(code).orElse(null);
    }

    @Override
    public CategoryEntity delete(String code) {
        return null;
    }
}
