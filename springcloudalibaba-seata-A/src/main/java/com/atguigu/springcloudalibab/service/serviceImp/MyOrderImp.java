package com.atguigu.springcloudalibab.service.serviceImp;

import com.atguigu.springcloudalibab.po.Order;
import com.atguigu.springcloudalibab.service.MyOder;
import com.atguigu.springcloudalibab.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyOrderImp implements OderService {

    @Autowired
    private MyOder myOder;

    @Override
    public Order create(Order order) {
        myOder.create(order);
        return order;
    }

    @Override
    public void update(Order order) {

    }
}
