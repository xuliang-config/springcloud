package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果 + server port:"+ port + result);
        if(result > 0){
            return new CommonResult(200,"插入成功" + port,result);
        }else{
            return new CommonResult(400,"插入数据库失败" + port);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") int id){
        Payment result = paymentService.getPaymentByID(id);
        log.info("*****查询结果 + server port"+port + result);
        if(result != null){
            return new CommonResult(200,"查询成功" + port,result);
        }else{
            return new CommonResult(400,"查询失败" + port);
        }
    }

    @GetMapping("/payment/discoveryClient")
    public Object getDiscovery(){

        //获取所有的微服务列表
        List<String> service = discoveryClient.getServices();
        for(String el : service){
            log.info(el);
        }
        //获取单个微服务的实例信息
        //微服务集群的情况下，一个服务会对应着多个实例
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance s : list){
            log.info(s.getServiceId() + "---" + s.getHost()+ "---"  +s.getPort() + "---" + s.getUri());
        }
        return discoveryClient;
    }


    @GetMapping("/payment/getPort")
    public String getServerPort(){
        return port;
    }
}
