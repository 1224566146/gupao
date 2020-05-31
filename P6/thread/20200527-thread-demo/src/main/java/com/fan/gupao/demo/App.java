package com.fan.gupao.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Queue<String> queue = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        int maxSize = 5;

        Producer producer = new Producer(queue, maxSize, lock, condition);
        Consumer consumer = new Consumer(queue, maxSize, lock, condition);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
