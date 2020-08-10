package com.fan.gupao.demo.springbootdubbosampleconsumer;

import com.fan.gupao.demo.ISayHelloService;

/**
 * @author 樊高风
 * @date 2020/8/10
 */
public class MockSayHelloService implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "触发服务降级";
    }
}
