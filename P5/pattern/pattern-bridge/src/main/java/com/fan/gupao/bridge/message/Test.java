package com.fan.gupao.bridge.message;

/**
 * @author 樊高风
 * @date 2020/7/1
 */
public class Test {

    public static void main(String[] args) {

        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NomalMessage(message);
        abstractMessage.sendMessage("加班申请", "王总");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("加班申请", "王总");
    }
}
