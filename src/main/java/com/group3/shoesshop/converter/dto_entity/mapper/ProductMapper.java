//package com.group3.shoesshop.converter.dto_entity.mapper;
//
//import com.group3.shoesshop.dto.BaseDTO;
//import com.group3.shoesshop.dto.ProductDTO;
//import com.group3.shoesshop.entity.BaseEntity;
//import com.group3.shoesshop.entity.OrderItemEntity;
//import com.group3.shoesshop.entity.ProductEntity;
//import com.group3.shoesshop.repository.OrderItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductMapper extends BaseMapper<ProductDTO, ProductEntity>{
//    @Autowired
//    private OrderItemRepository orderItemRepo;
//
//    @Override
//    public ProductDTO mapToDTO(BaseEntity entity) {
//        if (entity == null)
//            return null;
//        ProductDTO productDto = this.autoDTOMapper(entity, ProductDTO.class);
//        ProductEntity productEntity = (ProductEntity) entity;
//
//        // order items
//        if (productEntity.getOrderItems() != null) {
//            for (OrderItemEntity orderItemEntity: productEntity.getOrderItems())
//                productDto.getOrderItemIds().add(orderItemEntity.getId());
//        }
//
//        return productDto;
//    }
//
//    @Override
//    public ProductEntity mapToEntity(BaseDTO dto) {
//        if (dto == null)
//            return null;
//        ProductEntity productEntity = this.autoEntityMapper(dto, ProductEntity.class);
//        ProductDTO productDto = (ProductDTO) dto;
//
//        // order items
//        if (productDto.getOrderItemIds() != null) {
//            for (Integer id : productDto.getOrderItemIds()){
//                OrderItemEntity orderItemEntity = orderItemRepo.findById(id).orElse(null);
//                if (orderItemEntity != null)
//                    productEntity.getOrderItems().add(orderItemEntity);
//            }
//        }
//
//        return productEntity;
//    }
//}
