package com.fan.gupao.demo.auth.builderchain;

import com.fan.gupao.demo.auth.Member;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class MemberService {

    public void login(String loginName,String loginPass){
        Handler.Builder builder = new Handler.Builder();

        builder.addHandler(new ValidateHandler())
        .addHandler(new LoginHandler())
        .addHandler(new AuthHandler());

        builder.build().doHandler(new Member(loginName, loginPass));
    }

}
