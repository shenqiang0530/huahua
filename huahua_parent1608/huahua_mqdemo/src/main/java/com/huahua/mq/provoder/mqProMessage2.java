package com.huahua.mq.provoder;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "qa")
public class mqProMessage2 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("article.# 回复，"+message);
        System.out.println("接受信息！");
    }
}
