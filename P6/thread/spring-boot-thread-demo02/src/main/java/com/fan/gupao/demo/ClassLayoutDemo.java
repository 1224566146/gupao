package com.fan.gupao.demo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:15 2020/5/18
 */
public class ClassLayoutDemo {

    public static void main(String[] args) {

        ClassLayoutDemo classLayoutDemo = new ClassLayoutDemo();
        synchronized (classLayoutDemo){
            System.out.println("locking");
            System.out.println(ClassLayout.parseInstance(classLayoutDemo).toPrintable());
        }


    }

}
