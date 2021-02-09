package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController8004 {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String get(){
        log.info("aa");
        return "with zookeeper :" + serverPort;
    }

}
