package com.gupaoedu.limit;

import com.gupaoedu.util.ResourceUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * 消息生产者
 */
public class LimitProducer {

    private final static String QUEUE_NAME = "TEST_LIMIT_QUEUE";

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(ResourceUtil.getKey("rabbitmq.uri"));

        // 建立连接
        Connection connection = factory.newConnection();
        // 创建消息通道
        Channel channel = connection.createChannel();

        String msg = "a limit message";
        // 声明队列(默认交换机AMQP default,Direct)
        // String queue,boolean durable,boolean exclusive,boolean autoDelete,Map<String,Object> argments
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 发送消息
        // String exchange,String routingKey,BasicProperties props,byte[] body
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (msg+i).getBytes());
        }

        channel.close();
        connection.close();

    }

}
