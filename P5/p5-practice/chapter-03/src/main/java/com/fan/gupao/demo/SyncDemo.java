package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: SyncDemo
 * @ProjectName p5-practice
 * @Description: SyncDemo
 * @date 2020/6/6 14:34
 */
public class SyncDemo {

    // 对象锁（同一个对象有效） this
    public synchronized void demo(){

    }

    public void demo1(){
        synchronized (this){ // 对象锁
        }
    }

    // 类级别的锁
    public static synchronized void demo3(){

    }

    public void demo4(){
        synchronized (SyncDemo.class){

        }
    }

    public static void main(String[] args) {
        SyncDemo syncDemo=new SyncDemo();
        SyncDemo syncDemo1=new SyncDemo();
        //无法实现两个线程的互斥.
        //如果访问demo3的话，那么下面两个线程会存在互斥
        new Thread(()->{  //syncDemo这个实例
            syncDemo.demo1();
        }).start();

        new Thread(()->{ //BLOCKED状态
            syncDemo1.demo1();//syncDemo1这个实例
        }).start();
    }

}
