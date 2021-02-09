package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDaoTwo {
    public int create(Payment payment);

    public Payment getPaymentByID(@Param("id") int id);
}
