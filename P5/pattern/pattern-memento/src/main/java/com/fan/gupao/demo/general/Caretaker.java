package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class Caretaker {


    // 备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void storeMemento(Memento memento){
        this.memento = memento;
    }
}
