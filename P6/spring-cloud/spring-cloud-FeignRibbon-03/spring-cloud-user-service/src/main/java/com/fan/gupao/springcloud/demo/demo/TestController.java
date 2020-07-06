package com.fan.gupao.springcloud.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/2
 */
@RestController
public class TestController {

    @Qualifier
    @Autowired
    List<TestClass> testClassList = Collections.emptyList();

    @GetMapping("/test")
    public Object test(){
        return testClassList;
    }

}
