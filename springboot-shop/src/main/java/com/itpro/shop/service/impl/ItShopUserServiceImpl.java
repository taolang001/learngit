package com.itpro.shop.service.impl;

import com.itpro.shop.entity.ItShopUser;
import com.itpro.shop.mapper.ItShopUserMapper;
import com.itpro.shop.service.ItShopUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItShopUserServiceImpl implements ItShopUserService {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ItShopUserMapper itShopUserMapper;

    @Override
    public List<ItShopUser> getAllUserInfoList() {
        return itShopUserMapper.getAllUserInfoList();
    }

}
