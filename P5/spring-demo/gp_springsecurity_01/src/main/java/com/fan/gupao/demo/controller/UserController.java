package com.fan.gupao.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/19
 */
@RestController
public class UserController {

    @RequestMapping("/query")
    public String query(){
        return "hello";
    }

}
