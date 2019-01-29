package com.itpro.shop.mapper;

import com.itpro.shop.entity.ItShopUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItShopUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItShopUser record);

    int insertSelective(ItShopUser record);

    ItShopUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItShopUser record);

    int updateByPrimaryKey(ItShopUser record);

    List<ItShopUser> getAllUserInfoList();
}