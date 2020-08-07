package com.fan.gupao.demo.springclouddubbosampleprovider.services;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author 樊高风
 * @date 2020/8/7
 */
@Service
public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "Hello,"+msg;
    }
}
