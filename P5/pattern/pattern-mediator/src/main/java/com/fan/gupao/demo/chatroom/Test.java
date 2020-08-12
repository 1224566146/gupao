package com.fan.gupao.demo.chatroom;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class Test {

    public static void main(String[] args) {


        ChatRoom chatRoom = new ChatRoom();

        User tom = new User("Tom", chatRoom);
        User jerry = new User("Jerry", chatRoom);

        tom.sendMessage("Hi! I am Tom.");
        jerry.sendMessage("Hello!My name is Jerry");

    }

}
