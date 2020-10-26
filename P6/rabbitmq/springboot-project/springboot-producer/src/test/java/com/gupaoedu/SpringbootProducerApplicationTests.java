package com.gupaoedu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gupaoedu.producer.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProducerApplicationTests {

    @Autowired
    RabbitSender rabbitSender;

    @Test
    public void contextLoads() throws JsonProcessingException {
        rabbitSender.send();
    }

}
