package com.fan.gupao.demo;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 樊高风
 * @date 2020/6/15 15:21
 */
public class ServerSocketDemo {

    public static void main(String[] args) {


        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(9080);
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            // 如何转换成一个Object对象
            User user = (User) objectInputStream.readObject();
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
