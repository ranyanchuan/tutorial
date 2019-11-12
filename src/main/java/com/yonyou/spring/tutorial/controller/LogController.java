package com.yonyou.spring.tutorial.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LogController {

    private static final Log log = LogFactory.getLog(LogController.class);


    //用来定义一个保存输出的变量
    private Map<String, Object> params = new HashMap<>();

    // 添加不同类型的日志
    @RequestMapping(path = "/log/add/", method = RequestMethod.POST)
    public Map<String, Object> addLog(@RequestBody Map<String, String> map) {

        String type = map.get("type"); // 获取日志类型
        params.put("type", type);
//        log.info("请求：{} ,", "/log/add/");

        return params;
    }





}


