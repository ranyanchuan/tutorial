package com.yonyou.spring.tutorial.controller;

import com.yonyou.spring.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController

public class TestController {

    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    //用来定义一个保存输出的变量
    private Map<String, Object> params = new HashMap<>();

    @RequestMapping(path = "/test/{cityId}/{id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable() String cityId,
                           @PathVariable() String id,
                           @RequestHeader(value = "Authorization") String authorization
    ) {

        System.out.println("test----" );


        redisTemplate.opsForValue().set("hello","world");

//        redisTemplate.opsForHash().putAll("1111", "1111");
        System.out.println(redisTemplate.keys("*"));
        System.out.println(redisTemplate.opsForValue().get("chuan"));
        System.out.println(redisTemplate.opsForValue().get("hello"));
        System.out.println("test" + redisTemplate.hasKey("chuan"));

//        String allow = userService.getUserRoleByToken(authorization);
//
//        if ("success".equals(allow)) {
//            params.put("msg", "success");
//            params.put("cityId", cityId);
//            params.put("id", id);
//
////            String test = (String) redisTemplate.opsForValue().get("test");
////            System.out.println("test" + test);
//
//
//        } else {
//            params.put("msg", allow);
//        }
        return params;
    }

}
