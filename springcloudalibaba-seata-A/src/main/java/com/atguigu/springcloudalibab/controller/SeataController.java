package com.atguigu.springcloudalibab.controller;

import com.atguigu.springcloudalibab.po.Order;
import com.atguigu.springcloudalibab.service.MyOder;
import com.atguigu.springcloudalibab.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeataController {

    @Autowired
    private OderService oderService;

    @GetMapping("/create")
    public String create(Order o){
        Order a = oderService.create(o);
        System.out.println(a.id);
        return "OK";
    }
}
