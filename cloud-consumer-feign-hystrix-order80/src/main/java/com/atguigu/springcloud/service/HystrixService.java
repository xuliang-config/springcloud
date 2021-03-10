package com.atguigu.springcloud.service;

import com.atguigu.springcloud.serviceImp.HystrixServiceImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//@FeignClient(value = "cloud-prover-hystrix-service",fallback = HystrixServiceImp.class)
@FeignClient(value = "cloud-prover-hystrix-service")
public interface HystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/no/{id}")
    public String paymentInfo_no(@PathVariable("id") Integer id);

    @GetMapping("/payment/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id);
}
