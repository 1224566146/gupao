package com.fan.gupao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author 樊高风
 * @date 2020/6/13 15:30
 */
public class ProcessorHandler implements Runnable {

    Socket socket;
    Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            // 可以拿到那些信息？需要哪些信息
            // 反序列化
            RpcRequest request = (RpcRequest) inputStream.readObject();
            Object result = invoke(request);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Class.forName(request.getClassName());
        Method method = clazz.getMethod(request.getMethodName(), request.getTypes());
        Object invoke = method.invoke(service, request.getParamters());
        return invoke;
    }
}
