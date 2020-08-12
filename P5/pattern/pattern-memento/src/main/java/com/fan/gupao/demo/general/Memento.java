package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class Memento {

    private String state;


    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
