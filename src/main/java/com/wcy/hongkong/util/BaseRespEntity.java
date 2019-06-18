package com.wcy.hongkong.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author ndzzz
 * @date 16:14 2019/4/30
 * @Description:
 */
public class BaseRespEntity<T> implements Serializable {

    private String resp_code;
    private String resp_desc;
    private String resp_time;
    private T resp_info;

    public BaseRespEntity () {
        this.resp_code = ResponseEnum.SUCCESS_CODE.code;
        this.resp_desc = ResponseEnum.SUCCESS_CODE.msg;
        this.resp_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public BaseRespEntity (T data) {
        this.resp_code = ResponseEnum.SUCCESS_CODE.code;
        this.resp_desc = ResponseEnum.SUCCESS_CODE.msg;
        this.resp_info = data;
        this.resp_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public String getResp_code() {
        return resp_code;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
    }

    public String getResp_desc() {
        return resp_desc;
    }

    public void setResp_desc(String resp_desc) {
        this.resp_desc = resp_desc;
    }

    public String getResp_time() {
        return resp_time;
    }

    public void setResp_time(String resp_time) {
        this.resp_time = resp_time;
    }

    public T getResp_info() {
        return resp_info;
    }

    public void setResp_info(T resp_info) {
        this.resp_info = resp_info;
    }
}
