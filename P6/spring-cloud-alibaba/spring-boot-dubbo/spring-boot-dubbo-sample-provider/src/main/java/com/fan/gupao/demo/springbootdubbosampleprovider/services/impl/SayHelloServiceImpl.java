package com.fan.gupao.demo.springbootdubbosampleprovider.services.impl;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 樊高风
 * @date 2020/8/7
 */
@DubboService(registry = {"hunan"},
                protocol = {"dubbo","rest"},
                loadbalance = "random",
                cluster = "failover",
                retries = 2)
public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Msg:"+System.currentTimeMillis());
        return "[Version1.0]Hello"+msg;
    }
}
