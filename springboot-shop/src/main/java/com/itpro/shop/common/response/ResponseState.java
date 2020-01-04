package com.itpro.shop.common.response;

/**
 * 状态枚举
 */
public enum ResponseState {

    SUCCESS("10001", "请求成功"),
    CHECHERROR("10002", "参数验证错误"),
    TIMEOUT("10003", "登陆超时"),
    ERROR("10004", "系统未知错误"),
    NOTLOGIN("10005", "用户未登陆"),
    AUTHCCHECKERROR("10006", "权限认证失败");

    private String code;
    private String msg;

    private ResponseState(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
