package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${info.message}")
    public String infoMessage;

    @Value("${info.flash}")
    public String infoFlash;


    @GetMapping("/getTest")
    public String getInfoMessage(){
        return infoMessage +"/n" + infoFlash;
    }
}
