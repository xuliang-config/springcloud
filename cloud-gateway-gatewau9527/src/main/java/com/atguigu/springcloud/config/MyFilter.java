package com.atguigu.springcloud.config;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@Component    暂时不用这个过滤器
public class MyFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求里第一个请求参数值，key为username
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        //获取不着不能访问
        if(username == null){
            System.out.println("***非法登录****");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //改set方法会有一个返回值能返回
            return exchange.getResponse().setComplete();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;       //设置优先级，数字越小优先级越高
    }
}
