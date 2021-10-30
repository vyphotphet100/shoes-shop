package com.group3.shoesshop.converter.dto_entity.mapper;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.dto.CategoryDTO;
import com.group3.shoesshop.entity.BaseEntity;
import com.group3.shoesshop.entity.CategoryEntity;
import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryMapper extends BaseMapper<CategoryDTO, CategoryEntity> {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public CategoryDTO mapToDTO(BaseEntity entity) {
        if (entity == null)
            return null;

        CategoryDTO categoryDto = this.autoDTOMapper(entity, CategoryDTO.class);

        // products
        if (((CategoryEntity) entity).getProducts() != null)
            for (ProductEntity productEntity : ((CategoryEntity) entity).getProducts())
                categoryDto.getProductCodes().add(productEntity.getCode());

        return categoryDto;
    }

    @Override
    public CategoryEntity mapToEntity(BaseDTO dto) {
        if (dto == null)
            return null;

        CategoryEntity categoryEntity = this.autoEntityMapper(dto, CategoryEntity.class);

        // products
        CategoryDTO categoryDto = (CategoryDTO) dto;
        if (categoryDto.getProductCodes() != null)
            for (String code: categoryDto.getProductCodes()) {
                ProductEntity productEntity = productRepo.findById(code).orElse(null);
                if (productEntity != null)
                    categoryEntity.getProducts().add(productEntity);
            }

        return categoryEntity;
    }
}
