package com.yonyou.spring.tutorial.controller;

import com.yonyou.spring.tutorial.model.Order;
import com.yonyou.spring.tutorial.model.User;
import com.yonyou.spring.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    // 通过用户id 查询数据
    @RequestMapping(path = "/user/query/{id}", method = RequestMethod.GET)
    public User getProductById(@PathVariable String id) {

        System.out.println(userService.getUserBookById(id));
        return userService.getUserBookById(id);
    }


    // 通过用户id 查询数据
    @RequestMapping(path = "/user/add", method = RequestMethod.POST)
    public Map<String, String> getProductById(@RequestBody User user) {
        return userService.register(user.getPhone(), user.getPassword());
    }

    // 用户登录
    @RequestMapping(path = "/user/login/{phone}/{password}", method = RequestMethod.GET)
    public Map<String, String> login(@PathVariable String phone, @PathVariable String password) {
        return userService.login(phone, password);
    }

}
