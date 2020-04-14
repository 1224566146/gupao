package com.fan.gupao.project.controller;

import com.fan.gupao.project.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:22 2020/4/14
 */
@Controller
public class MyController {

    @Autowired
    private MyService myService;
}
