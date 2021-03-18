package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class Controller {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-provider-name}")
    public String server;

    @GetMapping("/consumer/nacos/{id}")
    public String getServer(@PathVariable("id") int id){
        return restTemplate.getForObject(server+"/nacos/getPort/"+id,String.class);
    }
}
