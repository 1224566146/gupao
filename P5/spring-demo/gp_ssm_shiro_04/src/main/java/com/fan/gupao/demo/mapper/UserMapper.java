package com.fan.gupao.demo.mapper;

import com.fan.gupao.demo.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/18
 */
public interface UserMapper {

    public List<User> query(@Param("userName") String userName);

    List<User> querySha1(@Param("userName")String userName);
}
