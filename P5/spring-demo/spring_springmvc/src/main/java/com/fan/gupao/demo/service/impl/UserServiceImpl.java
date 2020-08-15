package com.fan.gupao.demo.service.impl;

import com.fan.gupao.demo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author 樊高风
 * @date 2020/8/15
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public String hello() {
        return "Hello Service";
    }
}
