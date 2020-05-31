package com.fan.gupao.demo5.ioc;

import java.util.HashMap;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:17 2020/5/31
 */
public class IOCContainer {

    private static HashMap container = new HashMap();

    public static void putBean(String id, Object object){
        container.put(id, object);
    }

    public static Object getBean(String id){
        return container.get(id);
    }

}
