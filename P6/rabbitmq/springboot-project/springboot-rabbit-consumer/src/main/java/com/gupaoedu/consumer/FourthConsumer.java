package com.gupaoedu.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@PropertySource("classpath:gupaomq.properties")
@RabbitListener(queues = "${com.gupaoedu.fourthqueue}",containerFactory = "rabbitListenerContainerFactory")
public class FourthConsumer {

    @RabbitHandler    
    public void process(String msg) {
        System.out.println("Fouth Queue receivedc msg:"+msg);
    }
}
