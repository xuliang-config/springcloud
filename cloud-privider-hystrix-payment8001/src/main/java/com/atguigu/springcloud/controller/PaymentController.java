package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result =  paymentService.paymentInfo_ok(id);
        log.info("***result:"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/no/{id}")
    public String paymentInfo_no(@PathVariable("id") Integer id){
        String result =  paymentService.paymentInfo_no(id);
        log.info("***result:"+result);
        return result;
    }
    //==========服务熔断

    @GetMapping("/payment/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        String result =  paymentService.paymentCircuitBreaker(id);
        log.info("***result:"+result);
        return result;
    }
}
