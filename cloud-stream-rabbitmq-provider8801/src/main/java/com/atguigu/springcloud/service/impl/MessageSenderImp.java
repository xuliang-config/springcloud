package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.MessageSender;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)    //定义消息的推送管道
public class MessageSenderImp implements MessageSender {

    //消息推送管道，名字最好写成output,这样做最省事，或者指定装配的bean的名字，该类型的Bean有3个
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String str = UUID.randomUUID().toString();
        //MessageBuilder.withPayload(str).build()  能生成对应的消息
        //send方法发送消息
        output.send(MessageBuilder.withPayload(str).build());
        return null;
    }
}
