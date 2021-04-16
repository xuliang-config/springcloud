package com.atguigu.springcloudalibab.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@MapperScan("{com.atguigu.springcloudalibab.service}")
public class Mybatisconf {
}
