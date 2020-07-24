package com.fan.gupao.demo.auth.optimiaze;

import com.fan.gupao.demo.auth.Member;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class MemberService {


    public void login(String loginName,String loginPass){
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.setNext(loginHandler);
        loginHandler.setNext(authHandler);

        validateHandler.doHandler(new Member(loginName, loginPass));
    }
}
