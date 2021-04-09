package com.atguigu.springcloudalibaba.controller;

import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class RibbonController9003 {

    public static HashMap map = new HashMap();
    static{
        map.put(1L,"A");
        map.put(2L,"B");
        map.put(3L,"C");
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/ribbon/{id}")
    public CommonResult getTest(@PathVariable("id")Long id){
        return new CommonResult(200,port +"访问OK",map.get(id));
    }
}
