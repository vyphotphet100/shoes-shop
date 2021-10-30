package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.ProductDTO;
import com.group3.shoesshop.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<ProductDTO> implements IProductService {
    @Override
    public List<ProductDTO> findAll() {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO dto) {
        return null;
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        return null;
    }

    @Override
    public ProductDTO findOne(String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}
