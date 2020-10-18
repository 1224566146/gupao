package com.fan.gupao.demo.spring_oauth_resources_server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/10/18
 */
@RestController
public class UserController {


    @PreAuthorize(value = "hasAnyAuthority('ROOT')")
    @RequestMapping("/query1")
    public String query1(){
        return "query1...";
    }


    @PreAuthorize(value = "hasAnyAuthority('USER')")
    @RequestMapping("/query2")
    public String query2(){
        return "query2...";
    }
}
