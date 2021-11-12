package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.RoleEntity;
import com.group3.shoesshop.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseService<RoleEntity> implements IRoleService {
    @Override
    public List<RoleEntity> findAll() {
        return null;
    }

    @Override
    public RoleEntity save(RoleEntity entity) {
        return null;
    }

    @Override
    public RoleEntity update(RoleEntity entity) {
        return null;
    }

    @Override
    public RoleEntity findOne(String code) {
        return null;
    }

    @Override
    public RoleEntity delete(String code) {
        return null;
    }
}
