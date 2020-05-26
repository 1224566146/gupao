package com.fan.gupao.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:30 2020/5/26
 */
public class Dog {

    public String color;

    public void bark(){
        System.out.println("Dog barking!");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class clazz = Dog.class;

        // 创建对象
        Dog dog =(Dog)clazz.newInstance();

        // 获取类的结构
        // 父类
        System.out.println(clazz.getSuperclass());
        // 类的classloader
        System.out.println(clazz.getClassLoader());
        // 包名
        System.out.println(clazz.getPackage());
        // 类名
        System.out.println(clazz.getName());
        // ...

        Method method = clazz.getDeclaredMethod("bark");
        method.invoke(clazz.newInstance());

    }

}
