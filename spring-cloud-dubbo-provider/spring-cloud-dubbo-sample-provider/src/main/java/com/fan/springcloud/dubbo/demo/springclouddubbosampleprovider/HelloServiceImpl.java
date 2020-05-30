package com.fan.springcloud.dubbo.demo.springclouddubbosampleprovider;

import com.fan.springcloud.dubbo.demo.IHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:36 2020/5/29
 */
@Service
public class HelloServiceImpl implements IHelloService {


    @Value("${dubbo.application.name}")
    private String serviceName;


    @Override
    public String sayHello(String name) {
        return String.format("[%s]:Hello,%s", serviceName, name);
    }
}
