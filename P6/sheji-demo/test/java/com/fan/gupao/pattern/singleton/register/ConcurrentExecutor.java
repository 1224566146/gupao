package com.fan.gupao.pattern.singleton.register;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:08 2020/2/16
 */
public class ConcurrentExecutor {

    /**
     * 方法作用:信号量线程
     * @authorer: 樊高风 
     * @date: 2020/2/16 19:18
     * @param runHandler
     * @param executeCount 发起请求总数
     * @param concurrentCount 同时并发执行的线程数
     * @return:
     */
    public static void execute(final RunHandler runHandler,int executeCount,int concurrentCount) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        //控制信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(concurrentCount);
        //闭锁，可实现计数量递减
        final CountDownLatch countDownLatch = new CountDownLatch(executeCount);
        for (int i = 0;i < executeCount; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //执行此方法用于获取执行许可，当总计未释放的许可数不超过executeCount时，
                        //则允许同性，否则线程阻塞等待，知道获取到许可
                        semaphore.acquire();
                        runHandler.handler();
                        //释放许可
                        semaphore.release();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        executorService.shutdown();

    }

    public interface RunHandler{
        void handler();
    }
}
