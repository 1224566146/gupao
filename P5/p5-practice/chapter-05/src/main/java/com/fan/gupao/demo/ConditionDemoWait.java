package com.fan.gupao.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class ConditionDemoWait extends Thread{

    private Lock lock;
    private Condition condition;

    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    /**
     * synchronized(class){
     *     class.wait();
     * }
     */
    @Override
    public void run() {
        System.out.println("begin - ConditionDemoWait");
        try {
            lock.lock();//ThreadA获得了锁
            condition.await(); //阻塞
            System.out.println("end - ConditionDemoWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
