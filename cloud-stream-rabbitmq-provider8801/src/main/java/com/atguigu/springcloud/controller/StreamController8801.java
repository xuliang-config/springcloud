package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.MessageSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StreamController8801 {

    @Resource
    private MessageSender messageSender;

    @GetMapping("/send")
    public String send(){
        return messageSender.send();
    }
}
