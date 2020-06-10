package com.fan.gupao.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author 樊高风
 * @Title: SocketClientDemo
 * @ProjectName socket-client-demo
 * @Description: TODO
 * @date 2020/6/10 11:05
 */
public class SocketClientDemo {


    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost",9080);
            Thread.sleep(100000);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是客户端，发送了一个消息\n");
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverLine = bufferedReader.readLine();// 读取服务端返回的数据(被阻塞了)

            System.out.println("服务端返回的数据:"+serverLine);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
