package com.yonyou.spring.tutorial.dao;
import com.yonyou.spring.tutorial.model.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDetailDao {

    // 获取产品信息
    public ProductDetail selectProductById(@Param("id") String id);

    //
}
