package com.fan.gupao.project.service;

import com.fan.gupao.project.dao.MyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:24 2020/4/14
 */
@Service
public class MyService {

//    @Qualifier("dao")
    @Resource(name = "dao")
    private MyDao myDao;

    public void print() {
        System.out.println(myDao);
    }
}
