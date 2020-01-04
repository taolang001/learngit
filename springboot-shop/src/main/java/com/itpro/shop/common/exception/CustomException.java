package com.itpro.shop.common.exception;

import com.itpro.shop.common.response.ResponseState;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -912313432423534521L;

    //自定义错误码
    private String code;
    //自定义构造器,只保留一个,让其必须输入错误码及内容
    public CustomException(String code,String msg) {
        super(msg);
        this.code = code;
    }

    public CustomException(ResponseState responseState) {
        super(responseState.getMsg());
        this.code = responseState.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
