package com.fan.gupao.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 樊高风
 * @Title: ThreadPoolSelf
 * @ProjectName p5-practice
 * @Description: TODO
 * @date 2020/6/6 16:13
 */
public class ThreadPoolSelf extends ThreadPoolExecutor {
    public ThreadPoolSelf(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }

    // 任务执行开始
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    // 任务执行结束
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("初始线程数:"+this.getPoolSize());
        System.out.println("核心线程数:"+this.getCorePoolSize());
        System.out.println("正在执行的任务数量:"+this.getActiveCount());
        System.out.println("已经执行的任务数:"+this.getCompletedTaskCount());
        System.out.println("任务总数:"+this.getTaskCount());
    }
}
