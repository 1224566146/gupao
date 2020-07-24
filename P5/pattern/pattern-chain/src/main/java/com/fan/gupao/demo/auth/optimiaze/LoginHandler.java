package com.fan.gupao.demo.auth.optimiaze;

import com.fan.gupao.demo.auth.Member;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功!");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
