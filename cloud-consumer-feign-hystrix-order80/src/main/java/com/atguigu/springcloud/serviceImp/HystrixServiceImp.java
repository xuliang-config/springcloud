package com.atguigu.springcloud.serviceImp;

import com.atguigu.springcloud.service.HystrixService;
import org.springframework.stereotype.Component;

@Component
public class HystrixServiceImp implements HystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "出现异常了";
    }

    @Override
    public String paymentInfo_no(Integer id) {
        return "出现异常了";
    }

    @Override
    public String circuitBreaker(Integer id) {
        return null;
    }
}
