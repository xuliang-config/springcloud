package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StreamRabbitMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQMain8801.class,args);
    }
}
