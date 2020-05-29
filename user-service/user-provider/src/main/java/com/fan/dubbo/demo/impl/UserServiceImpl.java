package com.fan.dubbo.demo.impl;

import com.fan.dubbo.demo.IUserService;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:57 2020/5/29
 */
public class UserServiceImpl implements IUserService {
    public String getNameById(String uid) {
        System.out.println("receive request data:"+uid);
        return "樊高风";
    }
}
