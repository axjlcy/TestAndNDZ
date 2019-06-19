package com.wcy.hongkong.controller;

import com.wcy.hongkong.util.BaseRespEntity;
import com.wcy.hongkong.util.LoginBean;
import com.wcy.hongkong.util.RedisUtil;
import com.wcy.hongkong.util.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResigterController
{
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/register/ajax", produces = "application/json;charset=utf-8")
    @ResponseBody
    public BaseRespEntity<LoginBean> loginController(@RequestBody LoginBean req)
    {
        BaseRespEntity<LoginBean> baseRespEntity = new BaseRespEntity<>();
        //用户名为空
        if (req.getUserName() == null)
        {
            baseRespEntity.setResp_code(ResponseEnum.USER_IS_NULL_CODE.getCode());
            baseRespEntity.setResp_desc(ResponseEnum.USER_IS_NULL_CODE.getMsg());
        }
        //密码为空
        else if (req.getPassWord() == null)
        {
            baseRespEntity.setResp_code(ResponseEnum.PSW_IS_NULL_CODE.getCode());
            baseRespEntity.setResp_desc(ResponseEnum.PSW_IS_NULL_CODE.getMsg());
        }
        //用户名已存在
        else if (redisUtil.get(req.getUserName()) != null) {
            baseRespEntity.setResp_code(ResponseEnum.USER_IS_EXISTENT_CODE.getCode());
            baseRespEntity.setResp_desc(ResponseEnum.USER_IS_EXISTENT_CODE.getMsg());
        }
        //成功
        else
        {
            baseRespEntity.setResp_code(ResponseEnum.REGISTER_SUCCESS_CODE.getCode());
            baseRespEntity.setResp_desc(ResponseEnum.REGISTER_SUCCESS_CODE.getMsg());
            baseRespEntity.setResp_info(req);
            redisUtil.set(req.getUserName(),req.getPassWord());
        }
        System.out.println("++++++++++++++" + req.toString());
        return baseRespEntity;
    }

}
