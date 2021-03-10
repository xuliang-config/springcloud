package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentInfo_defaultHandler")
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return hystrixService.paymentInfo_ok(id);
    };


    @GetMapping("/consumer/payment/hystrix/no/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
//    @HystrixCommand
    public String paymentInfo_no(@PathVariable("id") Integer id){
        return hystrixService.paymentInfo_no(id);
    };

    public String paymentInfo_defaultHandler(){
        return "消费者服务降级";
    }

//    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
//        return "消费者服务降级"+ id;
//    }
    @GetMapping("/consumer/payment/circuit/{id}")
    public String payment_circuitBreaker(@PathVariable("id") Integer id){
        return hystrixService.circuitBreaker(id);
    }
}
