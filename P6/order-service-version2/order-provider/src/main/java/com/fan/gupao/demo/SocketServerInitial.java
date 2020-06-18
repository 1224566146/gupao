package com.fan.gupao.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 樊高风
 * @date 2020/6/18 13:50
 */
//spring 容器启动完成之后，会发布一个ContextRefreshedEvent=
@Component
public class SocketServerInitial implements ApplicationListener<ContextRefreshedEvent> {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 启动服务
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9080);
            while (true){
                // 监听客户端的请求
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
