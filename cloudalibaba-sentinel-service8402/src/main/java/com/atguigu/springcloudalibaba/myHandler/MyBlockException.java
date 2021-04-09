package com.atguigu.springcloudalibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class MyBlockException {

    public static CommonResult blockHandlerA(String id,BlockException ex){
        return new CommonResult(500,"自定义兜底方法 handlerException",id);
    }

    public static CommonResult blockHandlerB(BlockException ex){
        return new CommonResult(500,"自定义兜底方法 handlerException2");
    }

    public static String blockHandlerC(BlockException exception){
        return "这是第一个限流降级方法";
    }

}
