package com.fan.gupao.demo.springclouddubbosampleprovider;

import com.fan.gupao.demo.IHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author 樊高风
 * @date 2020/8/27
 */
@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello() {
        return "Hello GuPao";
    }
}
