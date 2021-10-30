package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.RoleDTO;

public interface IRoleService extends IBaseService<RoleDTO> {
    RoleDTO findOne(String code);
    void delete(String code);
}
