package com.api.common.enums;


public enum ErrorMsg {

    ACCOUNT_EXIT("用户不存在"),
    PARAM_ERROR("参数错误"),
    MISSING_PARAMETER("请求body错误"),
    COOKIE_ERROR("cookie错误"),
    NO_ACCESS("无权限"),
    USERNAME_OR_PASSWORD_ERROR("用户不存在或密码错误"),
    USER_NOT_LOGIN("用户未登录"),
    UPLOAD_FAIL("文件上传失败"),
    CODE_ERROR("验证码错误"),
    REGISTER_ERROR("注册失败，请联系管理员"),
    SYSTEM_ERROR("系统错误"), PASSWORD_SAME("新旧密码不得相同"), PASSWORD_RESET_ERROR("密码修改失败"), FAVORITE_EXIT("已添加收藏");

    private String msg;

    ErrorMsg(String msg){
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
