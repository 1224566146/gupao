package com.fan.gupao.adapter.demo.passport;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class PassportService {

    public ResultMsg regist(String username,String password){
        return new ResultMsg(200, "注册成功", new Member());
    }

    public ResultMsg login(String username,String password){
        return null;
    }
}
