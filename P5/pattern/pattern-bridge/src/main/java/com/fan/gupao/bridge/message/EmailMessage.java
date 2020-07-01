package com.fan.gupao.bridge.message;

/**
 * @author 樊高风
 * @date 2020/7/1
 */
public class EmailMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件消息发送"+message+"给"+toUser);
    }
}
