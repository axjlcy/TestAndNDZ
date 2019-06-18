package com.wcy.hongkong.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ndzzz
 * @date 10:53 2019/6/18
 * @Description:
 */
@RestController
public class loginController {

    @PostMapping(value = "/login.action", produces = "application/json;charset=utf-8")
    public String loginController (@RequestBody loginBean req) {
        System.out.println("++++++++++++++" + req.toString());
        return null;
    }
}
