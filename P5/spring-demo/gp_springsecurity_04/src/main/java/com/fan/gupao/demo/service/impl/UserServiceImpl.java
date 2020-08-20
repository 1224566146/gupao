package com.fan.gupao.demo.service.impl;

import com.fan.gupao.demo.bean.UserBean;
import com.fan.gupao.demo.mapper.UserMapper;
import com.fan.gupao.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper mapper;

    @Override
    public UserBean queryByUserName(String userName) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 去数据库中查询
        List<UserBean> list = mapper.queryByUserName(s);
        System.out.println("自定义的认证操作....");
        if (list != null && list.size() == 1) {
            UserBean userBean = list.get(0);
            if (userBean != null) {
                // 帐号存在 给当前登录的帐号授权相关的角色
                List<SimpleGrantedAuthority> authr = new ArrayList<>();
                authr.add(new SimpleGrantedAuthority("ROLE_USER"));
                UserDetails user = new User(s, userBean.getPassword(),
                        userBean.getState() == 1,
                        true, true,
                        true, authr);
                return user;
            }
        }
        // 返回空表示帐号不存在
        return null;
    }
}
