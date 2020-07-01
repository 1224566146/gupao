package com.fan.gupao.bridge.message;

/**
 * @author 樊高风
 * @date 2020/7/1
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    @Override
    void sendMessage(String message, String toUser){
        message = "[加急]"+message;
        super.sendMessage(message, toUser);
    }

    public Object watch(String messageId){
        return null;
    }
}
