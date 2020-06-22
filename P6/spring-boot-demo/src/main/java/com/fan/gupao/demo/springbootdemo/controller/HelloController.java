package com.fan.gupao.demo.springbootdemo.controller;

import com.fan.gupao.demo.springbootdemo.dao.entity.User;
import com.fan.gupao.demo.springbootdemo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/6/22 14:03
 */
@RestController
public class HelloController {

    @Autowired
    private IUserService userService;


    @GetMapping("/test")
    public String test(){
        User user = new User();
        user.setName("樊高风");
        userService.insert(user);
        return "Hello Spring Boot";
    }
}
