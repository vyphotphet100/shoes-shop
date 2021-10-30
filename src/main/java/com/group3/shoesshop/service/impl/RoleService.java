package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.dto.RoleDTO;
import com.group3.shoesshop.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseService<RoleDTO> implements IRoleService {
    @Override
    public List<RoleDTO> findAll() {
        return null;
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        return null;
    }

    @Override
    public RoleDTO update(RoleDTO dto) {
        return null;
    }

    @Override
    public RoleDTO findOne(String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}
