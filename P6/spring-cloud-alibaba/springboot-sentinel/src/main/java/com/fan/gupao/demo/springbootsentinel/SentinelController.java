package com.fan.gupao.demo.springbootsentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/9/21
 */
@RestController
public class SentinelController {


    @Autowired
    TestService testService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return testService.doTest(name);
    }

}
