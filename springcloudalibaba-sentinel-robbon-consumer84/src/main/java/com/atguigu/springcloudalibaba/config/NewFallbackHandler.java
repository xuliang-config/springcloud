package com.atguigu.springcloudalibaba.config;

import com.atguigu.springcloud.entities.CommonResult;

public class NewFallbackHandler {

    public static CommonResult dealExceptionA(Long id,Throwable e){
        return new CommonResult(500,e.getMessage() + id + "兜底方法");
    }
}
