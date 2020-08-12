package com.fan.gupao.demo.chatroom;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class User {

    private String name;

    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }


    public void sendMessage(String msg){
        this.chatRoom.showMsg(this, msg);
    }

}
