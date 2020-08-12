package com.fan.gupao.demo.chatroom;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class ChatRoom {

    public void showMsg(User user,String msg){
        System.out.println("["+user.getName()+"]:"+msg);
    }

}
