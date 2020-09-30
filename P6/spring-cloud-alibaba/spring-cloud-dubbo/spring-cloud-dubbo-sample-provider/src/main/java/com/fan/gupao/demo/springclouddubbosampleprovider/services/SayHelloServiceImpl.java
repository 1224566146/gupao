package com.fan.gupao.demo.springclouddubbosampleprovider.services;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 樊高风
 * @date 2020/8/7
 */
@DubboService(cluster = "failfast")
public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "Hello," + msg;
    }

    @Override
    public String exceptionTest() {
      throw new RuntimeException("抛出异常");
    }
}
