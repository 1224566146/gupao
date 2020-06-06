package com.fan.gupao.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 樊高风
 * @Title: ExecutorsSelf
 * @ProjectName p5-practice
 * @Description: ExecutorsSelf
 * @date 2020/6/6 16:13
 */
public class ExecutorsSelf {

    public static ExecutorService ThreadPoolSelf(int nThreads) {
        return new ThreadPoolSelf(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
}
