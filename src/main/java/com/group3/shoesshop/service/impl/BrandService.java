package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.BrandDTO;
import com.group3.shoesshop.service.IBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService extends BaseService<BrandDTO> implements IBrandService {

    @Override
    public List<BrandDTO> findAll() {
        return null;
    }

    @Override
    public BrandDTO save(BrandDTO dto) {
        return null;
    }

    @Override
    public BrandDTO update(BrandDTO dto) {
        return null;
    }

    @Override
    public BrandDTO findOne(String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}
