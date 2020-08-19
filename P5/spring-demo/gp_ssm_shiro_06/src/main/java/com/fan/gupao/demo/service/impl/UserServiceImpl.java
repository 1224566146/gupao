package com.fan.gupao.demo.service.impl;

import com.fan.gupao.demo.bean.User;
import com.fan.gupao.demo.mapper.UserMapper;
import com.fan.gupao.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/18
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> query(String userName) {
        return userMapper.query(userName);
    }
}
