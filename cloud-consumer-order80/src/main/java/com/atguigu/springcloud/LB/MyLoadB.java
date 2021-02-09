package com.atguigu.springcloud.LB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadB {

    //定义一个原子类，初始值为0，记录访问次数，原子类能保证线程安全
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public ServiceInstance getNextServiceInstance(List<ServiceInstance> list){
        //没有服务地址返回null
        if(list == null || list.size() ==0){
            return null;
        }
        //访问次数除以总服务个数取余，得到该次list的下标
        int index =getAndIncrement() % list.size();
        //返回对应服务实例
        return list.get(index);
    }

    public final int getAndIncrement(){

        int current;
        int next;

        do{
            //获取当前访问次数
            current = atomicInteger.get();
            //如果小于2147483647，next代表的当前访问次数就次数加一
            //2147483647是Integer的最大值，大于或等于这个数，访问次数重置为1
            next = current >= 2147483647 ? 1 : current + 1;
        }while(!atomicInteger.compareAndSet(current,next));
        //atomicInteger.compareAndSet方法作为比较内存中第一次参数的地址值，判断是否变更过
        //如果变更过，返回false;如果没变更，把第二个参数值赋值给第一次参数，并返回true
        //是一种自旋锁

        System.out.println("********第" + next + "次访问");
        return next;
    }
}
