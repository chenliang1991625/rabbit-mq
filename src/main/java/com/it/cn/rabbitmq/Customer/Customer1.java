package com.it.cn.rabbitmq.Customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//    创建消息监听类，用于监听firstExchange的消息
@Component
@RabbitListener(queues = "firstQueues",containerFactory="rabbitListenerContainerFactory")
public class Customer1 {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("firstQueues接收到消息：" + message);
    }
}
