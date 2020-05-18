package com.fan.gupao.demo;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:05 2020/5/18
 */
public class SynchronizedDemo {

    Object lock = new Object();
    // 只针对于当前对象实例有效
    public SynchronizedDemo(Object lock){
        this.lock = lock;
    }

    void demo(){
        synchronized (lock){

        }
    }

    void demo03(){
        synchronized (this){
            // 线程安全性问题;
        }
    }

    // -------------- 类锁。针对所有对象都互斥
    synchronized static void demo04(){

    }

    void demo05(){
        synchronized (SynchronizedDemo.class){

        }
    }

    // 锁的范围
    // 实例锁，对象实例
    // 静态方法、类对象、类锁
    // 代码块
    public static void main(String[] args) {
      Class clazz =  SynchronizedDemo.class;
      Object object1= new Object();
      Object object2 = new Object();
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo(object1);
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo(object2);

        // 锁的互斥性
        new Thread(()->{
            synchronizedDemo.demo();
        },"t1").start();

        new Thread(()->{
            synchronizedDemo1.demo();
        },"t2").start();
    }

}
