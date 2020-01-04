package com.itpro.shop.controller;
import com.itpro.shop.common.exception.CustomException;
import com.itpro.shop.common.response.ResponseState;
import com.itpro.shop.common.response.ResponseVO;
import com.itpro.shop.common.utils.ResultMessageUtils;
import com.itpro.shop.entity.ItShopUser;
import com.itpro.shop.service.ItShopUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/itShopUser")
public class ItShopUserController {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ItShopUserService ItShopUserService;

    @PostMapping(value = "/getAllUserList")
    @ResponseBody
    public ResponseVO getAllUserList() {
        ResponseVO vo = new ResponseVO();
        try {
            List<ItShopUser> userList = ItShopUserService.getAllUserInfoList();
            vo.setData(userList);
        } catch (Exception e) {
            logger.error("getAllUserList error", e);
            if (e instanceof CustomException) {
                ResultMessageUtils.checkException(e, vo, ResponseState.ERROR.getCode(), e.getMessage());
            } else {
                ResultMessageUtils.checkException(e, vo, ResponseState.ERROR.getCode(), "获取用户信息错误");
            }
        }
        return vo;
    }

    @GetMapping("/test")
    public String test() {
        return "xxxxx";
    }
}
