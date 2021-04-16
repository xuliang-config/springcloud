package com.atguigu.springcloudalibaba.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements OpenFeign {
    @Override
    public String getA() {
        return "openfeign兜底方法";
    }

    @Override
    public String getB() {
        return "openfeign兜底方法";
    }
}
