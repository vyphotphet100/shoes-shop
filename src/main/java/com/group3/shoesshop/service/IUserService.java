package com.group3.shoesshop.service;

import com.group3.shoesshop.dto.TransferPaymentDTO;
import com.group3.shoesshop.dto.UserDTO;

import java.util.List;

public interface IUserService extends IBaseService<UserDTO>{
    UserDTO findOne(Integer id);
    void delete(Integer id);

    UserDTO findByUsernameAndPassword(String username, String password);
    List<UserDTO> findAllSeller();
    List<UserDTO> findAllBuyer();

}
