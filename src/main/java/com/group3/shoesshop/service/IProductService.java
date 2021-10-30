package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.ProductDTO;

public interface IProductService extends IBaseService<ProductDTO>{
    ProductDTO findOne(String code);
    void delete(String code);
}
