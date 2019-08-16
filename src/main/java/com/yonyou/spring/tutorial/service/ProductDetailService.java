package com.yonyou.spring.tutorial.service;

import com.yonyou.spring.tutorial.dao.OrderDao;
import com.yonyou.spring.tutorial.dao.ProductDetailDao;
import com.yonyou.spring.tutorial.model.Order;
import com.yonyou.spring.tutorial.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductDetailService {


    @Autowired
    private ProductDetailDao productDetail;

    public ProductDetail getProductDetailById(String id) {
        return productDetail.selectProductById(id);
    }




}
