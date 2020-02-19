package com.fan.gupao.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:01 2020/2/16
 */
    //Spring中的做法，就是用这种注册式单例
public class ContainerSingleton {

    private ContainerSingleton() {

    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = Class.forName(className).newInstance();
                ioc.put(className, obj);
                return obj;
            }
        }
        return ioc.get(className);
    }

}
