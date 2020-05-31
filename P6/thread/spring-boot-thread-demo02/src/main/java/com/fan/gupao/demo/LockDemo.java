package com.fan.gupao.demo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:12 2020/5/18
 */
public class LockDemo {

    public static void main(String[] args) {

        LockDemo lockDemo = new LockDemo();
        Thread t1 = new Thread(()->{
            synchronized (lockDemo){
                System.out.println("t1抢占到锁");
                System.out.println(ClassLayout.parseInstance(lockDemo).toPrintable());
            }
        });
        t1.start();

        synchronized (lockDemo){
            System.out.println("Main 抢占到锁");
            System.out.println(ClassLayout.parseInstance(lockDemo).toPrintable());
        }

    }

}
