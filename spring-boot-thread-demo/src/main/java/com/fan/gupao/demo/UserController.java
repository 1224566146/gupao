package com.fan.gupao.demo;

import com.fan.gupao.demo.persistence.User;
import com.fan.gupao.demo.service.IUserService;
import com.fan.gupao.demo.service.SmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:18 2020/5/17
 */
@RestController
public class UserController {


    @Autowired
    private IUserService userService;

    @Autowired
    private SmsClient smsClient;

    @PostMapping("/user")
    public String addUser(User user){
        long start = System.currentTimeMillis();
        userService.insert(user);
        long end = System.currentTimeMillis();
        return "SUCCESS:"+(end-start);
    }

    ExecutorService executorService =  Executors.newFixedThreadPool(10);

    @PostMapping("/sms/user")
    public String register(User user){
        long start = System.currentTimeMillis();
        userService.insert(user);
        // 异步.Future ->
        // 会创建N个线程
        // MQ来代替
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                smsClient.sendSms("13264426426");
            }
        });

        long end = System.currentTimeMillis();
        return "SUCCESS:"+(end-start);
    }

}
