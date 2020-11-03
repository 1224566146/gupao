package com.fan.assign.singlepart;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 *
 */
public class SinglePartitionProducer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.105.128:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 0 发出去就确认 | 1 leader 落盘就确认 | all(-1) 所有Follower同步完才确认
        properties.put("acks", "1");
        // 异常自动重试次数
        properties.put("retries", 3);
        // 多少条数据发送一次,默认16K
        properties.put("batch.size", 16384);
        // 批量发送的等待时间
        properties.put("linger.ms", 5);
        // 客户端缓冲区大小,默认32M,满了也会触发消息发送
        properties.put("buffer.memory", 33554432);
        // 获取元数据时生产者的阻塞时间,超时后抛出异常
        properties.put("max.block.ms", 3000);

        Producer<String,String> producer = new KafkaProducer<String, String>(properties);

        // 全部发送到一个分区,不知道哪位幸运儿能消费到
        producer.send(new ProducerRecord<>("singlepartition", 0,"0","0qs"));
        producer.send(new ProducerRecord<>("singlepartition", 0,"1","1qs"));
        producer.send(new ProducerRecord<>("singlepartition", 0,"2","2qs"));
        producer.send(new ProducerRecord<>("singlepartition", 0,"3","3qs"));
        producer.send(new ProducerRecord<>("singlepartition", 0,"4","4qs"));

        producer.close();


    }

}
