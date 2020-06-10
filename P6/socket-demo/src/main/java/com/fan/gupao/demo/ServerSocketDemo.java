package com.fan.gupao.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 樊高风
 * @Title: ServerSocketDemo
 * @ProjectName socket-demo
 * @Description: TODO
 * @date 2020/6/10 10:53
 */
public class ServerSocketDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {


        ServerSocket serverSocket = null;
        try {
            // localhost:8080
            serverSocket = new ServerSocket(9080);

            while (true){
                Socket socket = serverSocket.accept();// 监听客户端连接（连接阻塞）
                System.out.println(socket.getPort());
                executorService.execute(new SocketThread(socket));  // 异步
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
