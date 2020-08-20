package com.fan.gupao.demo.service;

import com.fan.gupao.demo.bean.UserBean;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public interface IUserService extends UserDetailsService {

   UserBean queryByUserName(String userName);
}
