package com.itpro.shop.common.response;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.LinkedHashMap;

/**
 * 返回前台数据公共类
 */
@ControllerAdvice
public class ResponseVO extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ResponseVO() {
        this.setResponseCode(ResponseState.SUCCESS.getCode());
        this.setResponseMsg(ResponseState.SUCCESS.getMsg());
    }

    public ResponseVO(String responseCode) {
        this.setResponseCode(ResponseState.SUCCESS.getCode());
    }

    public ResponseVO(String responseCode, String responseMsg) {
        this.setResponseCode(responseCode);
        this.setResponseMsg(responseMsg);
    }

    public String getResponseCode(String responseCode) {
        return (String) this.get("responseCode");
    }

    public ResponseVO setResponseCode(String responseCode) {
        this.put("responseCode", responseCode);
        return this;
    }

    public String getResponseMsg(String responseMsg) {
        return (String) this.get("responseCode");
    }

    public ResponseVO setResponseMsg(String responseMsg) {
        this.put("responseMsg", responseMsg);
        return this;
    }

    public Object getData() {
        return this.get("data");
    }

    public ResponseVO setData(Object data) {
        this.put("data", data);
        return this;
    }
}
