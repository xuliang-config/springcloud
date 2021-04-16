package com.atguigu.springcloudalibab.service;

import com.atguigu.springcloudalibab.po.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyOder {
    void create(Order order);

    void update(Order order);
}
