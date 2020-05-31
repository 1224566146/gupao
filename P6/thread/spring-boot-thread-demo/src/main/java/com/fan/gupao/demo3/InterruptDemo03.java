package com.fan.gupao.demo3;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:20 2020/5/17
 */
public class InterruptDemo03 implements Runnable{

    static volatile boolean interrupt =false;

    @Override
    public void run() {
        while (!interrupt){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        interrupt = true;
    }
}
