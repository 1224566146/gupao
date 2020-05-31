package com.fan.gupao.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:13 2020/2/16
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        try {
            //很无聊的情况下，进行破坏
            Class<?> clazz = LazyInnerClassSingleton.class;
//            Class<?> clazz = HungrySingleton.class;
            //通过反射拿到私有的构造方法
            Constructor<?> c = null;
            c = clazz.getDeclaredConstructor(null);

            //强制访问，强吻  不愿意也要吻
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();
            System.out.println("o1:"+o1);

            //调用了两次构造方法，相当于new两次
            //犯了原则性问题
            Object o2 = c.newInstance();
            System.out.println("o2:"+o2);

            System.out.println(o1 == o2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
