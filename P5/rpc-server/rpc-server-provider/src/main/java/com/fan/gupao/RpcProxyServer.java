package com.fan.gupao;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 樊高风
 * @date 2020/6/13 15:37
 */
public class RpcProxyServer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 功能描述:
     * @param service
     * @param port
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/6/13 15:41
     */
    public void publisher(Object service, int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                final Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket, service));
            }
        }catch (Exception e){

        }
    }

}
