package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/18
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/query")
    public String query(@RequestParam(required = false) String userName){
        return userService.query(userName).toString();
    }

}
