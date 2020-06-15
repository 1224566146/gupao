package com.fan.gupao.demo;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author 樊高风
 * @date 2020/6/15 15:24
 */
public class ClientSocketDemo {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",9080);
            User user = new User();
            user.setName("樊高风");
            user.setAge(18);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(user);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
