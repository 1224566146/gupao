package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class Originator {

    // 内部状态
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 创建一个备忘录
    public Memento createMemento(){
        return new Memento(this.state);
    }

    // 从备忘录恢复
    public void restoreMemento(Memento memento){
        this.setState(memento.getState());
    }
}
