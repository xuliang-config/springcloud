package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

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
            return new CommonResult(400,"查询数据库失败" + port);
        }
    }

    @GetMapping("/payment/getPort")
    public String getServerPort(){
        return port;
    }
}