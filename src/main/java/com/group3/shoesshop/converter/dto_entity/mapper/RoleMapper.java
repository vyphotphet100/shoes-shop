package com.group3.shoesshop.converter.dto_entity.mapper;

import com.group3.shoesshop.dto.BaseDTO;
import com.group3.shoesshop.dto.RoleDTO;
import com.group3.shoesshop.entity.BaseEntity;
import com.group3.shoesshop.entity.RoleEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper extends BaseMapper<RoleDTO, RoleEntity>{
    @Autowired
    private UserRepository userRepo;

    @Override
    public RoleDTO mapToDTO(BaseEntity entity) {
        if (entity == null)
            return null;
        RoleDTO roleDto = this.autoDTOMapper(entity, RoleDTO.class);

        // users
        RoleEntity roleEntity = (RoleEntity) entity;
        if (roleEntity.getUsers() != null) {
            for (UserEntity userEntity: roleEntity.getUsers())
                roleDto.getUserIds().add(userEntity.getId());
        }

        return roleDto;
    }

    @Override
    public RoleEntity mapToEntity(BaseDTO dto) {
        if (dto == null)
            return null;
        RoleEntity roleEntity = this.autoEntityMapper(dto, RoleEntity.class);

        // users
        RoleDTO roleDto = (RoleDTO) dto;
        if (roleDto.getUserIds() != null) {
            for (Integer id : roleDto.getUserIds()){
                UserEntity userEntity = userRepo.findById(id).orElse(null);
                if (userEntity != null)
                    roleEntity.getUsers().add(userEntity);
            }
        }

        return roleEntity;
    }
}
