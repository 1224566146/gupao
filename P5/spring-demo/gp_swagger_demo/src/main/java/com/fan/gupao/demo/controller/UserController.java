package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.bean.UserBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author 樊高风
 * @date 2020/8/25
 */
@Api(tags = {"用户管理"})
@RestController
public class UserController {


    @ApiIgnore
    @GetMapping("/user/hello")
    public String hello() {
        return "Hello Swagger...";
    }

    @ApiOperation("用户管理-查询用户信息")
    @PostMapping("/user/query")
    public UserBean query(@RequestBody UserBean user) {
        System.out.println(user.getUserName() + "  ---- " + user.getPassword());
        return user;
    }

}
