package com.atguigu.springcloudalibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "cloudalibaba-sentinel-service-provider",fallback = ServiceImpl.class)
public interface OpenFeign {
    @GetMapping("/getAA")
    public String getA();

    @GetMapping("/getB")
    public String getB();
}
