package com.fan.gupao.bridge.message;

/**
 * @author 樊高风
 * @date 2020/7/1
 */
public interface IMessage {

    // 发送消息的内容和接收人
    void send(String message,String toUser);
}
