package com.fan.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 *
 */
public class ChargingInterceptor implements ProducerInterceptor<String,String> {
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        System.out.println("1分钱1条消息,不管那么多反正先扣钱");
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        System.out.println("消息被服务端接收了");
    }

    @Override
    public void close() {
        System.out.println("生产者关闭了");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("configure....");
    }
}
