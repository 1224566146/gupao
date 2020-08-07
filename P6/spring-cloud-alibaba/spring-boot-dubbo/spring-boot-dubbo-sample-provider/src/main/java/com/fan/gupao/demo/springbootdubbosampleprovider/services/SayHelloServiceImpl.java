package com.fan.gupao.demo.springbootdubbosampleprovider.services;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 樊高风
 * @date 2020/8/7
 */
@DubboService(registry = {"shanghai","hunan"},version = "1.0")
public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "[Version1.0]Hello"+msg;
    }
}
