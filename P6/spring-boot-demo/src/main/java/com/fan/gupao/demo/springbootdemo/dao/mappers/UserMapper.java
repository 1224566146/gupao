package com.fan.gupao.demo.springbootdemo.dao.mappers;

import com.fan.gupao.demo.springbootdemo.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 樊高风
 * @date 2020/6/22 13:59
 */
@Mapper
public interface UserMapper {

    int insert(User user);

}
