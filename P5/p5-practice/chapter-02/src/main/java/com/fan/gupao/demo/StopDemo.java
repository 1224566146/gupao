package com.fan.gupao.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author 樊高风
 * @Title: StopDemo
 * @ProjectName p5-practice
 * @Description: StopDemo
 * @date 2020/6/6 14:06
 */
public class StopDemo {

    static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new StopThread());
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        stop=true;

    }

    static class StopThread implements Runnable{

        @Override
        public void run() {
            while (!stop){
                System.out.println("持续运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
