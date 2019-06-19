package com.wcy.hongkong.util;

/**
 * @author ndzzz
 * @date 16:25 2019/4/30
 * @Description:
 */
public enum  ResponseEnum {

    INIT_CODE("0000","初态"),
    LOGIN_SUCCESS_CODE("1111","登录成功"),
    REGISTER_SUCCESS_CODE("1112","注册成功"),
    USER_IS_NULL_CODE("8886","账号为空"),
    USER_IS_EXISTENT_CODE("8887","账号已存在"),
    USER_NON_EXISTENT_CODE("8888","账号不存在"),
    PSW_IS_NULL_CODE("9998","密码为空"),
    PSW_ERROR_CODE("9999","密码错误");
    public String code;
    public String msg;

    ResponseEnum(String code, String msg) {
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
