package com.fan.gupao.demo.springbootzookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author 樊高风
 * @date 2020/9/7
 */
public class MutexDemo {

    public static void main(String[] args) {

        CuratorFramework curatorFramework=
                CuratorFrameworkFactory.builder()
                .connectString("192.168.105.128:2181,192.168.105.129:2181,192.168.105.130:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .connectionTimeoutMs(4000)
                .build();
        // 表示启动
        curatorFramework.start();

        /**
         * locks表示命名空间
         * 锁的获取逻辑是放在zookeeper
         * 当前锁是跨进程可见
         */
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/locks");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"->尝试抢占锁");
                try {
                    // 抢占锁,没有抢到,则阻塞
                    lock.acquire();
                    System.out.println(Thread.currentThread().getName()+"->获取锁成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(4000);
                    // 释放锁
                    lock.release();
                    System.out.println(Thread.currentThread().getName()+"->释放锁成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"t-"+i).start();
        }

    }
}
