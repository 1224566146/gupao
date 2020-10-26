package com.gupaoedu.dlx;

import com.gupaoedu.util.ResourceUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * 消息生产者,通过TTL测试死信队列
 */
public class DlxProducer {


    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(ResourceUtil.getKey("rabbitmq.uri"));

        // 建立连接
        Connection connection = factory.newConnection();
        // 创建消息通道
        Channel channel = connection.createChannel();

        String msg = "Hello world,Rabbit MQ,DLX MSG";

        // 设置属性,消息10秒钟过期
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                // 持久化消息
                .deliveryMode(2)
                .contentEncoding("UTF-8")
                // TTL
                .expiration("10000")
                .build();

        // 发送消息
        channel.basicPublish("", "GP_ORI_USE_QUEUE",properties , msg.getBytes());

        channel.close();
        connection.close();

    }

}
