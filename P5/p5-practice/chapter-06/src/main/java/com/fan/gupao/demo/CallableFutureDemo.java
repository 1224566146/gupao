package com.fan.gupao.demo;

import java.util.concurrent.*;

/**
 * @author 樊高风
 * @Title: CallableFutureDemo
 * @ProjectName p5-practice
 * @Description: CallableFutureDemo
 * @date 2020/6/6 16:10
 */
public class CallableFutureDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Hello 樊高风");
        Thread.sleep(3000);
        return "樊高风";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new CallableFutureDemo());
        new Thread(futureTask).start();
        // get方法属于阻塞方法
        System.out.println(futureTask.get());

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask future =(FutureTask) executorService.submit(new CallableFutureDemo());
        System.out.println(future.get());
    }
}
