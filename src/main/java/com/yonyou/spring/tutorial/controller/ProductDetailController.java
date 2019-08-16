package com.yonyou.spring.tutorial.controller;

import com.yonyou.spring.tutorial.model.ProductDetail;
import com.yonyou.spring.tutorial.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductDetailController {
    @Autowired
    ProductDetailService productDetailService;
    @GetMapping("/{id}")

    public ProductDetail getProductById(@PathVariable String id) {
        System.out.println("id"+id);
        return productDetailService.getProductDetailById(id);
    }

}







