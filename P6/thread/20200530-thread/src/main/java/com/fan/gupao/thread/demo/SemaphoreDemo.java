package com.fan.gupao.thread.demo;

import java.util.concurrent.Semaphore;

/**
 * @author 樊高风
 * @Title: SemaphoreDemo
 * @ProjectName 20200530-thread
 * @Description: TODO
 * @date 2020/5/31 16:32
 */
public class SemaphoreDemo {


    public static void main(String[] args) {

        Semaphore semaphore= new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Car(semaphore, i).start();
        }

    }

    static class Car extends Thread {
        Semaphore semaphore;
        int num;

        public Car(Semaphore semaphore, int num) {
            this.semaphore = semaphore;
            this.num = num;
        }

        @Override
        public void run() {
            try {

                semaphore.acquire();   // 获得令牌.(没拿到令牌，会阻塞，拿到了就可以往下执行）

                System.out.println("第" + num + "线程占用一个令牌");
                Thread.sleep(3000);

                System.out.println("第" + num + "线程释放一个令牌");
                semaphore.release();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
