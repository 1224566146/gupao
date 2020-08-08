package com.fan.gupao.demo.gper;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public class UnLoginState extends UserState {
    @Override
    public void favorite() {
        this.switch2Login();
        this.context.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.switch2Login();
        this.context.getState().comment(comment);
    }

    private void switch2Login(){
        System.out.println("跳转到登录页");
        this.context.setState(AppContext.STATE_LOGIN);
    }
}
