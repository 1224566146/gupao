package com.fan.gupao.demo6;

import java.util.HashMap;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:57 2020/5/26
 */
public class IOCContainer {

    private static HashMap container = new HashMap();

    public static void putBean(String id,Object object){
        container.put(id, object);
    }

    public static Object getBean(String id){
       return container.get(id);
    }

}
