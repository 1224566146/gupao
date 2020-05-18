package com.fan.gupao.demo.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:24 2020/5/18
 */
public class TestMain {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        int maxSize = 5;
        Product product = new Product(queue, maxSize);
        Consumer consumer = new Consumer(queue, maxSize);
        Thread t1 = new Thread(product);
        Thread t2 = new Thread(consumer);

        t2.start();
        t1.start();

    }
}
