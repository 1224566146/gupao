package com.fan.gupao.demo.springbootdubbosampleprovider.services.impl;

import com.fan.gupao.demo.springbootdubbosampleprovider.services.IDemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 樊高风
 * @date 2020/8/10
 */
@DubboService(protocol = {"dubbo"})
public class DemoService implements IDemoService {
    @Override
    public String getTxt() {
        return "Hello Gupaoedu.cn/8.8";
    }
}
