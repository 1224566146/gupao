package com.fan.gupao.demo.queue;

import java.util.UUID;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:21 2020/5/29
 */
public class Producer implements Runnable {

    private MyQueue<String> queue;

    public Producer(MyQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            queue.add(UUID.randomUUID().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
