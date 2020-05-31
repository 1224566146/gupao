package com.fan.gupao.demo3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:55 2020/5/26
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        basicOper();
//        filedOper();
//        methodOper();
        constructorOper();
    }

    public static void basicOper() {
        // 获取一个Class的对象实例
        Class clazz = Boy.class;

//       Class clazz2 = new Boy().getClass();
//
//        try {
//           Class clazz3 = Class.forName("com.fan.gupao.demo3.Boy");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Class<?> clazz4 = Main.class.getClassLoader().loadClass("com.fan.gupao.demo3.Boy");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        // 获取类的修饰符
        int modifiers = clazz.getModifiers();
        System.out.println("modifiers:" + modifiers);

        // 获取类的包
        Package boyPackage = clazz.getPackage();
        System.out.println("boyPackage:" + boyPackage);

        // 获取类的全名
        System.out.println(clazz.getName());
        // 获取类的简名
        System.out.println(clazz.getSimpleName());

        // 获取类的加载器
        System.out.println(clazz.getClassLoader());

        // 获取类的接口
        System.out.println(clazz.getInterfaces().length);

        // 获取类的父类
        System.out.println(clazz.getSuperclass());

        // 获取类的注解
        System.out.println(clazz.getAnnotations().length);

    }

    public static void filedOper() throws Exception {
        // 获取一个Class的对象实例
        Class clazz = Boy.class;
        Boy boy = (Boy) clazz.newInstance();

        // 获取当前类当中所有的共有字段，包含继承
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 获取类中指定的字段
        Field name = clazz.getField("name");
        System.out.println(name.getName());

        // 获取当前类中所有字段
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }

        Field weightField = clazz.getDeclaredField("weight");
        System.out.println(weightField.getModifiers());

        // 让私有字段进行强制访问
        weightField.setAccessible(true);
        weightField.set(boy, 180);

        System.out.println(boy.getWeight());

        Field desc = clazz.getField("desc");
        desc.set(null, "这是一个静态的属性内容！");
        System.out.println(Boy.desc);
    }

    public static void methodOper() throws Exception{
        Class clazz = Boy.class;
        Boy boy = (Boy) clazz.newInstance();

        // 获取类中所有的公共方法，包括父类
        Method[] methods = clazz.getMethods();
        System.out.println("public method 一共有"+methods.length+"个");
        for (Method method : methods) {
            System.out.println(method);
        }

        // 获取类中指定名字的方法
        Method talk = clazz.getMethod("talk");
        System.out.println(talk.getName());

        // 获取类中指定名字和参数的方法
        Method playball = clazz.getMethod("playball", String.class);
        System.out.println(playball.getName());
        System.out.println(playball.getModifiers());
        playball.invoke(boy, "兵兵球");

        // 获取本类所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("declareMethods"+declaredMethods.length);
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }


        Method pickUpGirl = clazz.getDeclaredMethod("pickUpGirl");
        System.out.println(pickUpGirl.getModifiers());
        pickUpGirl.setAccessible(true);
        pickUpGirl.invoke(boy);

        Method playBasketball = clazz.getDeclaredMethod("playBasketball");
        playBasketball.invoke(null);

    }


    public static void constructorOper() throws Exception{
        Class clazz = Boy.class;
        clazz.newInstance();   //  --------> constructor 进行对象的创建

        System.out.println(clazz.getConstructors().length);
        System.out.println(clazz.getDeclaredConstructors().length);

        // 获取clazz中无参的构造器
        Constructor constructor = clazz.getDeclaredConstructor();

        Constructor constructor1 = clazz.getDeclaredConstructor(int.class);

        Constructor constructor2 = clazz.getDeclaredConstructor(int.class, int.class);

        System.out.println(constructor.getModifiers());
        System.out.println(constructor1.getModifiers());
        System.out.println(constructor2.getModifiers());

        Boy boy =(Boy) constructor.newInstance();
        System.out.println(boy);

        boy = (Boy) constructor2.newInstance(176, 130);
        System.out.println(boy.getWeight());

        constructor1.setAccessible(true);
        boy =(Boy) constructor1.newInstance(175);
        System.out.println(boy.height);
    }
}
