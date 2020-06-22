package com.fan.gupao.demo.springbootdemo.services.impl;

import com.fan.gupao.demo.springbootdemo.dao.entity.User;
import com.fan.gupao.demo.springbootdemo.dao.mappers.UserMapper;
import com.fan.gupao.demo.springbootdemo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 樊高风
 * @date 2020/6/22 14:01
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
