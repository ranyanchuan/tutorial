package com.yonyou.spring.tutorial.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yonyou.spring.tutorial.model.Order;
@Mapper
public interface OrderDao {
    // 插入订单
    int insertOrder(@Param("order") Order order);

}
