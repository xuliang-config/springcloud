package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDaoTwo;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDaoTwo paymentDaoTwo;

    @Override
    public int create(Payment payment) {
        return paymentDaoTwo.create(payment);
    }

    @Override
    public Payment getPaymentByID(int id) {
        return paymentDaoTwo.getPaymentByID(id);
    }
}
