package com.atguigu.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8402 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8402.class,args);
    }
}