package com.fan.gupao.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/6/22 10:09
 */
@RestController
public class HelloController {


    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

}
