package com.fan.gupao.demo.springclouddubbosampleconsumer;

import com.fan.gupao.demo.ISayHelloService;

/**
 * @author 樊高风
 * @date 2020/9/30
 */
public class SayHelloServiceMock implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "触发了降级,返回默认数据";
    }

    @Override
    public String exceptionTest() {
        return "触发了降级,返回默认数据";
    }
}
