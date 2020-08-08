package com.fan.gupao.demo.general.apply;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public abstract class State {

    protected Context context;


    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handle();

}
