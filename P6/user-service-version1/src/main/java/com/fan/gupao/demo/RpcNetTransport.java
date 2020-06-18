package com.fan.gupao.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author 樊高风
 * @date 2020/6/18 10:05
 */
public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket newSocket() throws IOException {
        Socket socket = new Socket(host,port);
        return socket;
    }

    public Object send(RpcRequest request){
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            Socket socket = newSocket();
            // IO操作
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();

            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
