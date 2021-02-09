package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.LB.MyLoadB;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLoadB myLoadB;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment1/create")
    public CommonResult<Payment> create1(Payment payment){
        ResponseEntity<CommonResult> ent = restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        if(ent.getStatusCode().is2xxSuccessful()){
            return ent.getBody();
        }else{
            return new CommonResult<>(404,"错误",null);
        }
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") int id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") int id){
        ResponseEntity<CommonResult> ent = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(ent.getStatusCode().is2xxSuccessful()){
            return ent.getBody();
        }else{
            return new CommonResult<>(404,"错误",null);
        }
    }


    @GetMapping("/consumer/payment")
    public CommonResult<Payment> getTest(){
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = myLoadB.getNextServiceInstance(list);
//        String uri = serviceInstance.getUri() + "/payment/getPort";
        String uri = serviceInstance.getUri() + "/payment/get/1";
        return restTemplate.getForObject(uri,CommonResult.class);
    }



}
