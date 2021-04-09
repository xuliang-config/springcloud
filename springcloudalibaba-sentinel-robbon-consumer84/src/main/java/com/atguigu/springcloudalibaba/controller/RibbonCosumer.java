package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
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
    @SentinelResource(value = "ribbon",fallback = "handlerException")
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
}
