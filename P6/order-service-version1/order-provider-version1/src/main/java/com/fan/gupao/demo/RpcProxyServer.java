package com.fan.gupao.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 樊高风
 * @date 2020/6/18 9:52
 */
public class RpcProxyServer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object service,int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket,service));
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
