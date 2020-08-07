package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/8/7
 */
public class LoginServiceImpl implements ILoginService {
    @Override
    public String login(String username, String password) {
        // 写业务逻辑
        if(username.equals("admin")&&password.equals("admin")){
            return "SUCCESS";
        }
        return "FAILED";
    }
}
