package com.fan.gupao.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RefreshScope
@RestController
@RequestMapping("/user")
public class ConfigController {

    @Value("${env}")
    private String txt;

    @GetMapping("/config")
    public String config(){
        return txt;
    }
}
