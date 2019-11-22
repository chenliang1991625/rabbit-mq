package com.it.cn.rabbitmq.rabbitTest;

import com.it.cn.rabbitmq.RabbitMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= RabbitMqApplication.class)
public class RabbitTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    //    编写测试类方法：
    @Test
    public void testSendTopic1() {
        rabbitTemplate.convertAndSend("firstExchange", "first.qu", "first.qu主题模式");
    }


    @Test
    public void testSendTopic2() {
        rabbitTemplate.convertAndSend("firstExchange", "qeq.queues", "qeq.queues主题模 式");
    }

    @Test
    public void testSendTopic3() {
        rabbitTemplate.convertAndSend("firstExchange", "second.queues", "second.queues主题模式");
    }




    @Component
    @RabbitListener(queues = "myQueues",containerFactory="rabbitListenerContainerFactory")
    public class Customer3 {
        @RabbitHandler
        public void showMessage(String message) {
            System.out.println("myQueues接收到消息：" + message);
        }
    }
}
