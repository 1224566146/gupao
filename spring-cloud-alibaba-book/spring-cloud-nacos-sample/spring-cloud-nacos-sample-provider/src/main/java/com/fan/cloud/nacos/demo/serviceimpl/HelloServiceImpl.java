package com.fan.cloud.nacos.demo.serviceimpl;

import com.fan.cloud.nacos.demo.IHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author 樊高风
 * @date 2020/6/16 21:56
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        return "Hello World:"+name;
    }
}
