package com.example.demo;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:36 2020/5/25
 */
public class ThreadLocalDemo {

    static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    static ThreadLocal<Integer> local1 = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {


        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(()->{
               local1.set(10);
               int num = local.get(); // 获得的值都是0
                local.set(num+=5); // 设置到local中， thread[0] -> thread[1]
                System.out.println(Thread.currentThread().getName()+"-"+num);
                local.remove();
            });
        }

        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }


    }

}
