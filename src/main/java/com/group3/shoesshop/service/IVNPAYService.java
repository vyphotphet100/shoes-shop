package com.group3.shoesshop.service;

import com.group3.shoesshop.entity.OrderItemEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IVNPAYService {
    String getRedirectLink(HttpServletRequest request, List<OrderItemEntity> orderItemEntities) throws IOException;
}
