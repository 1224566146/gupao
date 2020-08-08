package com.fan.gupao.demo.gper;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public class LoginState extends UserState {
    @Override
    public void favorite() {
        System.out.println("收藏成功!");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
