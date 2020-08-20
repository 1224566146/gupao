package com.fan.gupao.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/19
 */
@RestController
public class UserController {

    @Secured(value = {"ROLE_USER"})
    @RequestMapping("/query")
    public String query(){
        return "hello";
    }


    @Secured(value = {"ROLE_CREATE"})
    @RequestMapping("/user/create")
    public String create(){
        return "hello create";
    }

}
