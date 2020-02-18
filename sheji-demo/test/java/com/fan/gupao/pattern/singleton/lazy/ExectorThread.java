package com.fan.gupao.pattern.singleton.lazy;

import com.fan.gupao.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:57 2020/2/16
 */
public class ExectorThread implements Runnable {
    @Override
    public void run() {

//        LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName()+":"+lazySimpleSingleton);

//        LazyDoubleCheckSingleton lazyDoubleCheckSingleton = LazyDoubleCheckSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName()+":"+lazyDoubleCheckSingleton);

        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+instance);


    }
}
