package com.itpro.shop.service;

import com.itpro.shop.entity.ItShopUser;

import java.util.List;


public interface ItShopUserService {

    /**
     * 获取所有用户信息
     * @return List<User>
     */
    List<ItShopUser> getAllUserInfoList();
}
