package com.itpro.shop.common.utils;

import com.itpro.shop.common.exception.CustomException;
import com.itpro.shop.common.response.ResponseVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResultMessageUtils {

    /**
     * 前台统一异常处理
     * 判断是否为自定义异常
     */
    public static void checkException(Exception e, ResponseVO vo, String errCode, String msg){
        if (e instanceof CustomException) {
            vo.setResponseCode(((CustomException) e).getCode());
            vo.setResponseMsg(e.getMessage());
        } else {
            vo.setResponseCode(errCode);
            vo.setResponseMsg(msg);
        }
    }
}
