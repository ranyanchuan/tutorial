package com.yonyou.spring.tutorial.controller;

import com.yonyou.spring.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    //用来定义一个保存输出的变量
    private Map<String, Object> params = new HashMap<>();

    @RequestMapping(path = "/auth", method = RequestMethod.GET)
    public Object findUser(@RequestHeader(value = "Authorization") String auth) {
        String allow = userService.getUserRoleByToken(auth);
        //  输出认证信息
        params.put("msg", allow);
        return params;
    }
}
