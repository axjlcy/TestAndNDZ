package com.wcy.hongkong.controller;

import com.wcy.hongkong.configEntity.loginBean;
import com.wcy.hongkong.util.BaseRespEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ndzzz
 * @date 10:53 2019/6/18
 * @Description:
 */
@Controller
public class loginController
{
    @RequestMapping(value="/")
    public String test()
    {
        return "redirect:/login.html";
    }

    @PostMapping(value = "/login/ajax", produces = "application/json;charset=utf-8")
    @ResponseBody
    public BaseRespEntity<loginBean> loginController(@RequestBody loginBean req)
    {
        BaseRespEntity<loginBean> baseRespEntity = new BaseRespEntity<>();


        if (req.getUserName().equals("wcy")) {
            baseRespEntity.setResp_code("0000");
            baseRespEntity.setResp_desc("success");
            baseRespEntity.setResp_info(req);
        }
        else {
            baseRespEntity.setResp_code("9999");
            baseRespEntity.setResp_desc("false");
            baseRespEntity.setResp_info(req);
        }
        System.out.println("++++++++++++++" + req.toString());
        return baseRespEntity;
    }
}
