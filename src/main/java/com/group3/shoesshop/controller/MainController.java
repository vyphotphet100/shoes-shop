package com.group3.shoesshop.controller;

import com.group3.shoesshop.converter.dto_entity.mapper.BrandMapper;
import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.dto.BrandDTO;
import com.group3.shoesshop.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private DTOEntityConverter converter;

    @Autowired
    private BrandMapper brandMapper;

    @GetMapping("/test")
    public String test() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setCode("TestCode");
        brandEntity.setName("Test Name");
        brandEntity.setProducts(null);

//        ProductEntity productEntity1 = new ProductEntity();
//        productEntity1.setCode("productCode1");
//        brandEntity.getProducts().add(productEntity1);
//        ProductEntity productEntity2 = new ProductEntity();
//        productEntity2.setCode("productCode2");
//        brandEntity.getProducts().add(productEntity2);

        BrandDTO brandDTO = converter.toDTO(brandEntity, brandMapper);
        BrandEntity brandEntity2 = converter.toEntity(brandDTO, brandMapper);
        return null;
    }

}
