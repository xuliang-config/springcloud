package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.myHandler.MyBlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController8402 {

    @GetMapping("/getAA")
    public String getA() {
        return "com from 8402 A";
    }

    @GetMapping("/getB")
    public String getB(){
        return "com from 8402 B";
    }

    @GetMapping("/getC")
    @SentinelResource(value = "getC" ,blockHandler = "deal_Exception")
    public String getC(@RequestParam(value = "id",required = false) String id,
                       @RequestParam(value = "name",required = false) String name){
        System.out.println(id);
        System.out.println(name);
        return "Hot Key testOK";
    }

    public String deal_Exception(String id, String name, BlockException ex){
        return "sentinel热点限流了，返回兜底方法";
    }


    @GetMapping("/getD")
    @SentinelResource(value = "getD" ,blockHandlerClass = MyBlockException.class,blockHandler = "blockHandlerA")
    public CommonResult  getD(@RequestParam(value = "id",required = false) String id){
        return new CommonResult(200,"Hot Key testOK",1);
    }
}
