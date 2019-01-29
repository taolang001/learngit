package com.itpro.shop.common.exception;

import com.itpro.shop.common.utils.ResultMessageUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 全局异常处理:定义一个处理类,
 * 使用@ControllerAdvice注解。@ControllerAdvice注解:控制器增强,一个被@Component注册的组件。
 * 配合@ExceptionHandler来增强所有的@requestMapping方法。
 * 例如:@ExceptionHandler(Exception.class);
 * 用来捕获@requestMapping的方法中所有抛出的exception。
 */
/*@ControllerAdvice

public class GlobalDefultExceptionHandler {

    private Log logger = LogFactory.getLog(getClass());

    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> defultExcepitonHandler(Exception e) {
        if (e instanceof CustomException) {
            logger.error("自定义异常：" + e.getMessage());
            CustomException customException = (CustomException) e;
            return ResultMessageUtils.setResultMessage(customException.getCode(), customException.getMessage());
        } else {
            logger.error("系统异常：" + e);
            //系统未知错误
            return ResultMessageUtils.setResultMessage("9999", "系统异常");
        }
    }
}*/
