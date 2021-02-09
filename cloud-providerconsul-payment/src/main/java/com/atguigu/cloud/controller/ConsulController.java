package com.atguigu.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsulController {

    @Resource
    private RestTemplate restTemplate;

    private final String service = "http://consul-provider-payment";

    @GetMapping("/payment/consul/order")
    public String getService(){
        return restTemplate.getForObject(service+"/payment/consul",String.class);
    }
}
