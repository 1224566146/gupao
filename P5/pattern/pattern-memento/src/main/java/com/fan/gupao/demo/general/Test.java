package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class Test {


    public static void main(String[] args) {


        // 来一个发起人
        Originator originator = new Originator();
        // 来一个备忘录管理员
        Caretaker caretaker = new Caretaker();
        // 管理员存储发起人的备忘录
        caretaker.storeMemento(originator.createMemento());
        // 发起人从管理员获取备忘录进行回滚
        originator.restoreMemento(caretaker.getMemento());

    }
}
