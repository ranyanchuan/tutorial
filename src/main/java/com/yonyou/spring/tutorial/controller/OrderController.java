package com.yonyou.spring.tutorial.controller;

import com.yonyou.spring.tutorial.dao.OrderDao;
import com.yonyou.spring.tutorial.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yonyou.spring.tutorial.model.Order;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

@Autowired
OrderService orderService;

    @GetMapping("/{id}")
    public void getOne(@PathVariable int id) {
        System.out.println("id"+id);
//        return id;
    }

    @PostMapping
    public int crateOne(@RequestBody @Valid Order order) {
        return orderService.createOrder(order);
    }

}
