package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.BrandDTO;

public interface IBrandService extends IBaseService<BrandDTO>{
    BrandDTO findOne(String code);
    void delete(String code);
}
