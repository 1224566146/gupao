package com.fan.gupao.demo.service;

import com.fan.gupao.demo.bean.User;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/18
 */
public interface IUserService {

    public List<User> query(String userName);

    List<User> querySha1(String userName);
}
