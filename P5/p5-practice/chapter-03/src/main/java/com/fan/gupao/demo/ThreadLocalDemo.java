package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: ThreadLocalDemo
 * @ProjectName p5-practice
 * @Description: ThreadLocalDemo
 * @date 2020/6/6 14:36
 */
public class ThreadLocalDemo {

    private static Integer num = 0;

    public static final ThreadLocal<Integer> LOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0; // 初始值
        }
    };

    public static final ThreadLocal<Integer> LOCAL1 = new ThreadLocal<Integer>();

    public static void main(String[] args) {

        Thread[] threads = new Thread[5];
        // 希望每个线程都拿到的是0
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(()->{
                int num = LOCAL.get(); // 拿到初始值
                LOCAL1.get();
                num += 5;
                LOCAL.set(num);
                System.out.println(Thread.currentThread().getName()+"->"+num);
            },"Thread-"+i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }

}
