package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.RoleEntity;

public interface IRoleService extends IBaseService<RoleEntity> {
    RoleEntity findOne(String code);
    RoleEntity delete(String code);
}
