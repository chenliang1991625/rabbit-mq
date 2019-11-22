package com.it.cn.rabbitmq.Customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "myQueues",containerFactory="rabbitListenerContainerFactory")
public class Customer3 {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("myQueues接收到消息：" + message);
    }
}