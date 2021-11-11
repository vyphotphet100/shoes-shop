package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.BrandEntity;
import com.group3.shoesshop.repository.BrandRepository;
import com.group3.shoesshop.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService extends BaseService<BrandEntity> implements IBrandService {

    @Autowired
    private BrandRepository brandRepo;

    @Override
    public List<BrandEntity> findAll() {
        return brandRepo.findAll();
    }

    @Override
    public BrandEntity save(BrandEntity entity) {
        return null;
    }

    @Override
    public BrandEntity update(BrandEntity entity) {
        return null;
    }

    @Override
    public BrandEntity findOne(String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}
