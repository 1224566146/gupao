package com.fan.gupao.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author 樊高风
 * @Title: SocketThread
 * @ProjectName socket-demo
 * @Description: TODO
 * @date 2020/6/10 11:00
 */
public class SocketThread implements Runnable {

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 输入流
            String s = bufferedReader.readLine();// 被阻塞了
            String clientStr = s; // 读取客户端的一行数据
            System.out.println("接收到客户端的信息:"+clientStr);

            //写回去
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我收到了信息\n");
            bufferedWriter.flush();

            bufferedReader.close();
            bufferedWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
