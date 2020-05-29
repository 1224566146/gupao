package com.fan.gupao.demo.queue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:23 2020/5/29
 */
public class Consumer implements Runnable {

    private MyQueue<String> queue;

    public Consumer(MyQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            queue.remove();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
