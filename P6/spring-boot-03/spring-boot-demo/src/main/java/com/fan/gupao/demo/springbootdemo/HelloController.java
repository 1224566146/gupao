package com.fan.gupao.demo.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
@RestController
public class HelloController {

    // 在这里能够实现注入的前提是? IOC存在实例(自动装配)
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/say")
    public String say(){
        return (String) redisTemplate.opsForValue().get("name");
    }
}
