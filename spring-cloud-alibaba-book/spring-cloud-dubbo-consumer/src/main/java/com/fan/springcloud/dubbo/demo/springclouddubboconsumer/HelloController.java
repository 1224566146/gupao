package com.fan.springcloud.dubbo.demo.springclouddubboconsumer;

import com.fan.springcloud.dubbo.demo.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:45 2020/5/29
 */
@RestController
public class HelloController {


    @Reference
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello(){
        return iHelloService.sayHello("樊高风");
    }
}
