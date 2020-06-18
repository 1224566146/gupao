package com.fan.gupao.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/6/18 14:13
 */
@RestController
public class TestController {

    @GpReference
    private IOrderService orderService;

    @GpReference
    private ITestService testService;

    @GetMapping("/test")
    public String test(){
        return orderService.queryOrderList();
    }

    @GetMapping("/say")
    public String say(){
        return testService.sayHello();
    }

}
