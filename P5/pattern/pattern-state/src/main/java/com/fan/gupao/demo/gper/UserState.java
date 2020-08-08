package com.fan.gupao.demo.gper;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public abstract class UserState {

    protected AppContext context;

    public void setContext(AppContext context) {
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);
}
