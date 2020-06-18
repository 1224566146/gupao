package com.fan.gupao.demo;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 樊高风
 * @date 2020/6/18 13:37
 */
public class Mediator {

    // 用来存储发布的服务的实例(服务调用的路由)
    public static Map<String, BeanMethod> map = new ConcurrentHashMap<>();

    private volatile static Mediator instance;

    private Mediator(){}

    public static Mediator getInstance(){
        if(instance == null){
            synchronized (Mediator.class){
                if(instance == null){
                    instance = new Mediator();
                }
            }
        }
        return instance;
    }


    public Object processor(RpcRequest rpcRequest){
        String key = rpcRequest.getClassName()+"."+rpcRequest.getMethodName(); // key
        BeanMethod beanMethod = map.get(key);
        if(beanMethod == null){
            return null;
        }
        Object bean = beanMethod.getBean();
        Method method = beanMethod.getMethod();
        try {
            return method.invoke(bean, rpcRequest.getArgs());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
