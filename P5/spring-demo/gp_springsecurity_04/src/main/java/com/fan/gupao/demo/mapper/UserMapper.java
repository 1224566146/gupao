package com.fan.gupao.demo.mapper;

import com.fan.gupao.demo.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public interface UserMapper {

    List<UserBean> queryByUserName(@Param("userName") String userName);
}
