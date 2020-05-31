package com.fan.gupao.pattern.adapter.loginadapter.v1;

import com.fan.gupao.pattern.adapter.loginadapter.Member;
import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:16 2020/3/6
 */
public class SignService {


    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username,String password){
        return  new ResultMsg(200,"注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return null;
    }

}
