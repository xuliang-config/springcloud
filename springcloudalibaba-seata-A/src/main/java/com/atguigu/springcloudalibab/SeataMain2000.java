package com.atguigu.springcloudalibab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataMain2000 {
    public static void main(String[] args) {
        SpringApplication.run(SeataMain2000.class,args);
    }
}
