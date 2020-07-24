package com.fan.gupao.demo.auth.builderchain;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class Test {

    public static void main(String[] args) {

        MemberService memberService = new MemberService();
        memberService.login("tom", "666");

    }
}
