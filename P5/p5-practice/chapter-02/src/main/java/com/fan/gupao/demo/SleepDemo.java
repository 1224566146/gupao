package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: SleepDemo
 * @ProjectName p5-practice
 * @Description: SleepDemo
 * @date 2020/6/6 14:00
 */
public class SleepDemo extends Thread {

    public static void main(String[] args) {
        new SleepDemo().start();
    }

    @Override
    public void run() {
        System.out.println("begin:"+System.currentTimeMillis());
        try {
            Thread.sleep(3000);
            System.out.println("end:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
