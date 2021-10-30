package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.CategoryDTO;
import com.group3.shoesshop.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<CategoryDTO> implements ICategoryService {
    @Override
    public List<CategoryDTO> findAll() {
        return null;
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        return null;
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {
        return null;
    }

    @Override
    public CategoryDTO findOne(String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}
