package com.twShop.common.enums;


public enum ErrorMsg {

    ACCOUNT_EXIT("用户不存在"),
    PARAM_ERROR("参数错误"),
    MISSING_PARAMETER("请求body错误"),
    COOKIE_ERROR("cookie错误"),


    CODE_ERROR("验证码错误");

    private String msg;

    ErrorMsg(String msg){
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
