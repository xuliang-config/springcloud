package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloudalibaba.config.NewFallbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonCosumer {

    @Autowired
    private RestTemplate restTemplate;

    private String address = "http://cloudalibaba-sentinel-ribbon-provider";

    @GetMapping("/ribbon/{id}")
    @SentinelResource(value = "ribbon",fallback = "handlerException",fallbackClass = NewFallbackHandler.class)
    public CommonResult getTest(@PathVariable("id")Long id) {
        CommonResult result = restTemplate.getForObject(address+"/ribbon/"+id,CommonResult.class);
        if(id == 4){
            throw new IllegalArgumentException("参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("获取值异常");
        }
        return result;
    }

    public CommonResult handlerException(Long id,Throwable e){
        return new CommonResult(500,e.getMessage() + id);
    }


    @GetMapping("/getE/{id}")
    @SentinelResource(value = "ribbon",fallback = "dealExceptionA",fallbackClass = NewFallbackHandler.class,
            exceptionsToIgnore = NullPointerException.class)
    public CommonResult getTest1(@PathVariable("id")Long id) {
        if(id == 4){
            throw new IllegalArgumentException("参数异常");
        }else if(id == 5){
            throw new NullPointerException("获取值异常");
        }
        return new CommonResult(200,"ok");
    }
}
