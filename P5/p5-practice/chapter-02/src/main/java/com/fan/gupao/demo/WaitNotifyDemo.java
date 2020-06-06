package com.fan.gupao.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 樊高风
 * @Title: WaitNotifyDemo
 * @ProjectName p5-practice
 * @Description: TODO
 * @date 2020/6/6 14:19
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int size = 10;
        Producer producer = new Producer(queue, size);
        Consumer consumer = new Consumer(queue, size);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }

}
