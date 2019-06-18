package com.wcy.hongkong.util;

/**
 * @author ndzzz
 * @date 16:25 2019/4/30
 * @Description:
 */
public enum  ResponseEnum {

    SUCCESS_CODE("0000","成功"),
    FAIL_CODE("9999","失败");
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
