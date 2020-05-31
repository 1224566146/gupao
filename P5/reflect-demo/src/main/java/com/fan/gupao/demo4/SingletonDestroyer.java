package com.fan.gupao.demo4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:48 2020/5/26
 */
public class SingletonDestroyer {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Lazy instance = Lazy.getInstance();

        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);
        Lazy lazy = declaredConstructor.newInstance(); // 调用不成功

        System.out.println(instance == lazy);

    }

}
