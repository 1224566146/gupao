package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:02 2020/5/25
 */
public class Demo {

    static Map<String,Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();

    public static Object get(String key){
        read.lock(); // 读锁 ThreadA 阻塞
        try {
            return cacheMap.get(key);
        }finally {
            read.unlock(); // 释放读锁
        }
    }

    public static Object put(String key, String value){
        write.lock(); // Other Thread 获得了写锁
        try {
            return cacheMap.put(key, value);
        }finally {
            write.unlock();
        }
    }
}
