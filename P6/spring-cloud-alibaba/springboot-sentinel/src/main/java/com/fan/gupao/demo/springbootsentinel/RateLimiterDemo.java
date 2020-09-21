package com.fan.gupao.demo.springbootsentinel;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author 樊高风
 * @date 2020/9/21
 */
public class RateLimiterDemo {

    // 令牌桶算法
    RateLimiter rateLimiter = RateLimiter.create(10);

    public void doRequest(){
        // 获取令牌
        if(rateLimiter.tryAcquire()){
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
    }
}
