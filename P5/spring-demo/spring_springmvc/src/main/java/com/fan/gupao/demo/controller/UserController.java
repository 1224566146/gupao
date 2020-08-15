package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/15
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/hello")
    public String hello(){
        return userService.hello();
    }
}
