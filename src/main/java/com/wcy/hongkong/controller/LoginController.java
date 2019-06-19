package com.wcy.hongkong.controller;

import com.wcy.hongkong.util.LoginBean;
import com.wcy.hongkong.util.BaseRespEntity;
import com.wcy.hongkong.util.RedisUtil;
import com.wcy.hongkong.util.ResponseEnum;
import org.omg.PortableInterceptor.NON_EXISTENT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ndzzz
 * @date 10:53 2019/6/18
 * @Description:
 */
@Controller
public class LoginController
{
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/")
    public String toLogin()
    {
        return "redirect:/login.html";
    }

    @PostMapping(value = "/login/ajax", produces = "application/json;charset=utf-8")
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
        // 用户名不存在
        else if (redisUtil.get(req.getUserName()) == null) {
            baseRespEntity.setResp_code(ResponseEnum.USER_NON_EXISTENT_CODE.getCode());
            baseRespEntity.setResp_desc(ResponseEnum.USER_NON_EXISTENT_CODE.getMsg());
        }
        //密码不正确
        else if(!(redisUtil.get(req.getUserName()).toString().equals(req.getPassWord())))
        {
            baseRespEntity.setResp_code(ResponseEnum.PSW_ERROR_CODE.getCode());
            baseRespEntity.setResp_desc(ResponseEnum.PSW_ERROR_CODE.getMsg());
        }
        //成功
        else
        {
            baseRespEntity.setResp_code(ResponseEnum.LOGIN_SUCCESS_CODE.getCode());
            baseRespEntity.setResp_desc(ResponseEnum.LOGIN_SUCCESS_CODE.getMsg());
            baseRespEntity.setResp_info(req);
        }
        System.out.println("++++++++++++++" + req.toString());
        return baseRespEntity;
    }
}
