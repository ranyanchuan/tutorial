package com.yonyou.spring.tutorial.service;

import com.yonyou.spring.tutorial.dao.UserDao;
import com.yonyou.spring.tutorial.model.User;
import com.yonyou.spring.tutorial.utils.JwtUtil;
import com.yonyou.spring.tutorial.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    // 用户登录
    public Map<String, String> login(String phone, String password) {

        Map<String, String> map = new HashMap<String, String>();

        // 对明文加密
        String mdPass = MD5Utils.getMd5(password + phone); // md5 加密
        // 查询用户是否存在
        User user = userDao.getUserByPhonePass(phone, mdPass);

        if (user != null) {
            String token = JwtUtil.sign(phone, user.getId());
            map.put("token", token);
            map.put("phone", phone);
        }
        return map;
    }


    // 注册
    public Map<String, String> register(String phone, String password) {

        Map<String, String> map = new HashMap<String, String>();

        // 用户名已经注册
        User registerUser = userDao.getUserByPhone(phone);
        if (registerUser != null) {
            map.put("msg", phone + "该手机号已经被注册了");
            return map;
        }

        String userId = UUID.randomUUID().toString();
        User user = new User();
        user.setPhone(phone);
        user.setId(userId); // 用户id
        // 约定: admin管理员，user普通用户
        user.setRole("user"); // 用户id
        user.setPassword(MD5Utils.getMd5(password + phone)); // md5 加密

        // 添加用户
        userDao.addUser(user);

        // 生成token
        String token = JwtUtil.sign(phone, userId);
        map.put("token", token);
        map.put("phone", phone);
        return map;
    }


    // 通过用户id 获取用户book信息
    public User getUserBookById(String id) {
        return userDao.getUserBookById(id);
    }

    // 通过用户id 获取用户
    public String getUserRoleByToken(String token) {
        String status = "token 验证失败";
        if (JwtUtil.verify(token)) { // 验证token
            String userId = JwtUtil.getUserId(token);
            userDao.getUserBookById(userId);
            status = "success";
        }
        return status;
    }


}
