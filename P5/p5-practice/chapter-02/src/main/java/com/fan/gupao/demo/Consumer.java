package com.fan.gupao.demo;

import java.util.Queue;

/**
 * @author 樊高风
 * @Title: Consumer
 * @ProjectName p5-practice
 * @Description: Consumer
 * @date 2020/6/6 14:22
 */
public class Consumer implements Runnable {

    private Queue<String> bags;
    private int size;

    public Consumer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bags){
                while (bags.isEmpty()){
                    System.out.println("bags空了");
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String bag = bags.remove();
                System.out.println("消费者消费:"+bag);
                bags.notifyAll();
            }
        }
    }
}
