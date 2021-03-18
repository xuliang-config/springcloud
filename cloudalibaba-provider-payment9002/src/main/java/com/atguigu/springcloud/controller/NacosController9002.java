package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController9002 {
    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/getPort/{id}")
    public String getPort(@PathVariable("id")int id ){
        return port + ": 注册成功  :" + id;
    }
}
