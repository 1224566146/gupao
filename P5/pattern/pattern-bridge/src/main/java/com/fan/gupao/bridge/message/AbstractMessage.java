package com.fan.gupao.bridge.message;

/**
 * @author 樊高风
 * @date 2020/7/1
 */
public abstract class AbstractMessage {
    private IMessage message;

    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    void sendMessage(String message,String toUser){
        this.message.send(message, toUser);
    }
}
