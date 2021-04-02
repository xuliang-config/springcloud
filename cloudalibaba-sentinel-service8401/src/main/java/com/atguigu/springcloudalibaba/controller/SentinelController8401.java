package com.atguigu.springcloudalibaba.controller;

import com.atguigu.springcloudalibaba.service.OpenFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SentinelController8401 {

    @Resource
    private OpenFeign openFeign;

    @GetMapping("/getA")
    public String getA() {
        return openFeign.getA();
    }

    @GetMapping("/getB")
    public String getB(){
        return openFeign.getB();
    }
}
