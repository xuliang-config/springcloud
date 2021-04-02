package com.atguigu.springcloudalibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController8402 {

    @GetMapping("/getAA")
    public String getA() {
        return "com from 8402 A";
    }

    @GetMapping("/getB")
    public String getB(){
        return "com from 8402 B";
    }
}
