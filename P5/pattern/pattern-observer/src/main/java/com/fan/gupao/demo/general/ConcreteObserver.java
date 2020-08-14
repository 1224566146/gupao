package com.fan.gupao.demo.general;

/**
 * 具体观察者
 * @author 樊高风
 * @date 2020/8/14
 */
public class ConcreteObserver<E> implements IObserver<E> {
    @Override
    public void update(E event) {
        System.out.println("receive event:"+event);
    }
}
