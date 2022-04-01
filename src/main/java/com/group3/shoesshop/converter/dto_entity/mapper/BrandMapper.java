//package com.group3.shoesshop.converter.dto_entity.mapper;
//
//import com.group3.shoesshop.dto.BaseDTO;
//import com.group3.shoesshop.dto.BrandDTO;
//import com.group3.shoesshop.entity.BaseEntity;
//import com.group3.shoesshop.entity.BrandEntity;
//import com.group3.shoesshop.entity.ProductEntity;
//import com.group3.shoesshop.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BrandMapper extends BaseMapper<BrandDTO, BrandEntity> {
//    @Autowired
//    private ProductRepository productRepo;
//
//    @Override
//    public BrandDTO mapToDTO(BaseEntity entity) {
//        if (entity == null)
//            return null;
//
//        BrandDTO brandDto = this.autoDTOMapper(entity, BrandDTO.class);
//
//        // products
//        if (((BrandEntity) entity).getProducts() != null)
//            for (ProductEntity productEntity : ((BrandEntity) entity).getProducts())
//                brandDto.getProductCodes().add(productEntity.getCode());
//
//        return brandDto;
//    }
//
//    @Override
//    public BrandEntity mapToEntity(BaseDTO dto) {
//        if (dto == null)
//            return null;
//
//        BrandEntity brandEntity = this.autoEntityMapper(dto, BrandEntity.class);
//
//        // products
//        if (((BrandDTO) dto).getProductCodes() != null)
//            for (String code : ((BrandDTO) dto).getProductCodes()) {
//                ProductEntity productEntity = productRepo.findById(code).orElse(null);
//                if (productEntity != null)
//                    brandEntity.getProducts().add(productEntity);
//            }
//
//        return brandEntity;
//    }
//}
