package com.fan.serializer;

import org.apache.kafka.common.serialization.Serializer;
import java.util.Map;

/**
 * @author: qingshan
 * 生产者用到，序列化工具
 */
public class ProtobufSerializer implements Serializer<Protobufable> {
    //
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public byte[] serialize(String topic, Protobufable data) {
        return data.encode();
    }

    @Override
    public void close() {}
}

