package com.yonyou.spring.tutorial.service;

import com.yonyou.spring.tutorial.dao.OrderDao;
import com.yonyou.spring.tutorial.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public int createOrder(Order order) {
        return orderDao.insertOrder(order);
    }



}
