package com.yonyou.spring.tutorial.dao;

import com.yonyou.spring.tutorial.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    // 获取用户book 信息
    public User getUserBookById(@Param("id") String id);

    // 通过手机号获取用户
    public User getUserByPhone(@Param("phone") String phone);

    // 通过id获取用户
    public User getUserById(@Param("id") String id);

    // 添加用户
    public int addUser(@Param("user") User user);

    // 用户登录
    public User getUserByPhonePass(@Param("phone") String phone, @Param("password") String password);


}
