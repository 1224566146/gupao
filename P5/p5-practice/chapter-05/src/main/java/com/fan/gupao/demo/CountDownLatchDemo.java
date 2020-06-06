package com.fan.gupao.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author 樊高风
 * @Title: CountDownLatchDemo
 * @ProjectName p5-practice
 * @Description: CountDownLatchDemo
 * @date 2020/6/6 15:57
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        // state存储
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(()->{
            countDownLatch.countDown();  // 倒计时
            // 修改state=state-1 通过cas设置到state字段上
        }).start();


        new Thread(()->{
            countDownLatch.countDown();  // 倒计时
            // 修改state=state-1 通过cas设置到state字段上
        }).start();


        new Thread(()->{
            countDownLatch.countDown();  // 倒计时
            // 修改state=state-1 通过cas设置到state字段上
        }).start();

        countDownLatch.await(); // 阻塞主线程
        System.out.println("线程执行完毕");

    }

}
