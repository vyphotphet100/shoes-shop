package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.converter.dto_entity.mapper.UserMapper;
import com.group3.shoesshop.dto.UserDTO;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService<UserDTO> implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO save(UserDTO dto) {
        UserEntity userEntity = userRepo.findByUsername(dto.getUsername());
        if (userEntity != null)
            return this.exceptionObject(new UserDTO(), "This username exists.");

        userEntity = dtoEntityConverter.toEntity(dto, userMapper);
        dto = dtoEntityConverter.toDTO(userEntity, userMapper);
        dto.setMessage("Register account successfully.");
        return dto;
    }

    @Override
    public UserDTO update(UserDTO dto) {
        UserEntity userEntity = userRepo.findById(dto.getId()).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserDTO(), "This user id does not exist.");

        userEntity = dtoEntityConverter.toEntity(dto, userMapper);
        dto = dtoEntityConverter.toDTO(userEntity, userMapper);
        dto.setMessage("Update information successfully.");
        return dto;
    }

    @Override
    public UserDTO findOne(Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserDTO(), "This user id does not exist.");

        return dtoEntityConverter.toDTO(userEntity, userMapper);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public UserDTO findByUsernameAndPassword(String username, String password) {
        UserDTO userDto = dtoEntityConverter.toDTO(userRepo.findByUsernameAndPassword(username, password), userMapper);

        if (userDto == null)
            return this.exceptionObject(new UserDTO(), "Invalid username or password.");

        userDto.setMessage("Log in successfully.");
        return userDto;
    }

    @Override
    public List<UserDTO> findAllSeller() {
        List<UserDTO> userDtos = new ArrayList<>();
        List<UserEntity> userEntities = userRepo.findAllByRoleCode("SELLER");
        for (UserEntity userEntity: userEntities)
            userDtos.add(dtoEntityConverter.toDTO(userEntity, userMapper));

        return userDtos;
    }

    @Override
    public List<UserDTO> findAllBuyer() {
        List<UserDTO> userDtos = new ArrayList<>();
        List<UserEntity> userEntities = userRepo.findAllByRoleCode("BUYER");
        for (UserEntity userEntity: userEntities)
            userDtos.add(dtoEntityConverter.toDTO(userEntity, userMapper));

        return userDtos;
    }
}
