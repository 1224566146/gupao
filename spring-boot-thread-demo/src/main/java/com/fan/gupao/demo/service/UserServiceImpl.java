package com.fan.gupao.demo.service;

import com.fan.gupao.demo.persistence.User;
import com.fan.gupao.demo.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:17 2020/5/17
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
