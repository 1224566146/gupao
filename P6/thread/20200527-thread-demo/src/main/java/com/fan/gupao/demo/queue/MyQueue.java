package com.fan.gupao.demo.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:05 2020/5/29
 */
public class MyQueue<E> {

    private Object[] obj;
    private volatile int addIndex;
    private volatile int removeIndex;
    private volatile int queueSize;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public MyQueue(int queueSize) {
        obj = new Object[queueSize];
    }

    public void add(E e){
        lock.lock();
        while (queueSize == obj.length){
            System.out.println(Thread.currentThread().getName()+"队列已满，先等待");
            try {
                condition.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        obj[addIndex] = e;
        queueSize++;
        if(++addIndex==obj.length){
            addIndex = 0;
        }
        condition.signal();
        System.out.println(Thread.currentThread().getName()+"生产消息:"+e);
//        System.out.println(Thread.currentThread().getName()+"生产消息:"+ Arrays.toString(obj));
        lock.unlock();

    }

    public void remove(){
        lock.lock();
        while (queueSize == 0){
            System.out.println(Thread.currentThread().getName()+"队列空了，先等待");
            try {
                condition.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"消费消息："+obj[removeIndex]);
        obj[removeIndex] = null;
        queueSize--;
        if(++removeIndex == obj.length){
            removeIndex=0;
        }
        condition.signal();
//        System.out.println(Thread.currentThread().getName()+"消费之后"+Arrays.toString(obj));
        lock.unlock();
    }
}
