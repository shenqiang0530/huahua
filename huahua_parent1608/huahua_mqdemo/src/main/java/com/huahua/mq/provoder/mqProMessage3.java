package com.huahua.mq.provoder;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "qs")
public class mqProMessage3 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("#.log 回复，"+message);
        System.out.println("接受信息！");
    }
}
