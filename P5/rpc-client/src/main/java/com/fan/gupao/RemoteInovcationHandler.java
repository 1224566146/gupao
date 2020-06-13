package com.fan.gupao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 樊高风
 * @date 2020/6/13 15:46
 */
public class RemoteInovcationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInovcationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParamters(args);
        request.setTypes(method.getParameterTypes());
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
        Object result = rpcNetTransport.send(request);
        return result;
    }
}
