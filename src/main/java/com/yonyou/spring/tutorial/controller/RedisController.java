package com.yonyou.spring.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    //用来定义一个保存输出的变量
    private Map<String, Object> params = new HashMap<>();

    // 查询 key 是在 redis 中
    @RequestMapping(path = "/redis/query/{key}", method = RequestMethod.GET)
    public Object findValueByKey(@PathVariable() String key) {

        String value = redisTemplate.opsForValue().get(key.trim());
        params.put(key, value);
        return params;
    }

    // 添加键值对到 redis 中
    @RequestMapping(path = "/redis/add", method = RequestMethod.POST)
    public Object addKeyValue(@RequestBody Map<String, String> map) {

        String key = map.get("key");
        String value = map.get("value");
        redisTemplate.opsForValue().set(key, value);
        String redisValue = redisTemplate.opsForValue().get(key);
        params.put(key, redisValue);
        return params;
    }


}
