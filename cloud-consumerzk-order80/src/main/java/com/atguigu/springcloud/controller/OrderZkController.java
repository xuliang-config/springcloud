package com.atguigu.springcloud.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderZkController {

    @Resource
    private RestTemplate restTemplate;

    private final String service = "http://cloud-provider-payment-8004";

    @GetMapping("/payment/zk/order")
    public String getService(){
        return restTemplate.getForObject(service+"/payment/zk",String.class);
    }
}
