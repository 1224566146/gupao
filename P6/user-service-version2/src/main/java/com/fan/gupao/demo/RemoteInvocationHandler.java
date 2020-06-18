package com.fan.gupao.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 樊高风
 * @date 2020/6/18 14:06
 */
@Component
public class RemoteInvocationHandler implements InvocationHandler {

    @Value("${gp.host}")
    private String host;

    @Value("${gp.port}")
    private int port;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       // 先建立远程连接
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
        // 传递数据
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setArgs(args);
        rpcRequest.setTypes(method.getParameterTypes());

        return rpcNetTransport.send(rpcRequest);
    }
}
