package com.fan.gupao.demo;

import java.lang.reflect.Proxy;

/**
 * @author 樊高风
 * @date 2020/6/18 10:17
 */
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
