package com.huahua.mq.provoder;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "article")
public class MqProMessage1 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("article.log 回复，"+message);
        System.out.println("接受信息！");
    }
}
