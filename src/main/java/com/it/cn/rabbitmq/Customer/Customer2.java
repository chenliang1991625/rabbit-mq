package com.it.cn.rabbitmq.Customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "secondQueue",containerFactory="rabbitListenerContainerFactory")
public class Customer2 {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("secondQueue接收到消息：" + message);
    }
}
