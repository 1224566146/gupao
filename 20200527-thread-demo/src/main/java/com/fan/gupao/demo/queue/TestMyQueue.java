package com.fan.gupao.demo.queue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:24 2020/5/29
 */
public class TestMyQueue {


    public static void main(String[] args) {

        MyQueue<String> queue = new MyQueue<>(10);

        Producer producer = new Producer(queue);

        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(producer).start();

        new Thread(consumer).start();


    }
}
