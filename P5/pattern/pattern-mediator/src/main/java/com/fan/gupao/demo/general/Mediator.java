package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public abstract class Mediator {


    protected ConcreteColleagueA colleagueA;
    protected ConcreteColleagueB colleagueB;


    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    // 中介者逻辑
    public abstract void transferA();

    public abstract void transferB();
}
