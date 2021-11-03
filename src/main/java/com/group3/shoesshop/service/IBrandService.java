package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.BrandEntity;

public interface IBrandService extends IBaseService<BrandEntity>{
    BrandEntity findOne(String code);
    void delete(String code);
}
