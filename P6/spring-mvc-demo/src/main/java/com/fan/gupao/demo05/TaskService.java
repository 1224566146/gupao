package com.fan.gupao.demo05;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 樊高风
 * @date 2020/6/22 13:36
 */
@Service
public class TaskService {


    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println("current Time:"+new Date());
    }
}
