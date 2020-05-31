package com.example.demo;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:09 2020/5/25
 */
public class JoinDemo {

    private static int i = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            i = 30;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // Callable/Future(阻塞)
        t1.start();
        // t线程中的执行结果对于main线程可见.
        t1.join(); // Happens-Before模型

        // 我希望t线程的执行结果可见
        System.out.println("i"+i);

    }

}
