package com.example.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:54 2020/5/25
 */
public class AtomicDemo {

    private static int count = 0;

    // 重入锁(如何实现的？)
    static Lock lock = new ReentrantLock();

    public static void inc(){
        lock.lock(); // 获得锁（互斥锁）ThreadA 获得了锁
        try {
            //退出线程 中断的过程往下传递.  true
            // sleep/ join/ wait
            //while()
            // ...
            Thread.sleep(1);
            count++;
            decr();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();// 释放锁 ThreadA释放锁  state=1-1=0
        }
    }

    public static void decr(){
        lock.lock(); // state=2   //ThreadA再次来抢占锁 : 不需要再次抢占锁，而是只增加重入的次数
        try {

            count--;
        }finally {
            lock.unlock(); // state = 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->AtomicDemo.inc());
        t1.start();

//        Thread t2 = new Thread(()->AtomicDemo.inc());
//        t2.start();
//        t2.interrupt();

        for (int i = 0; i < 1000; i++) {
            new Thread(()->AtomicDemo.inc()).start();
        }
        Thread.sleep(4000);
        System.out.println("result:"+count);
    }
}
