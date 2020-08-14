package com.fan.gupao.demo.general;

/**
 * 抽象观察者
 * @author 樊高风
 * @date 2020/8/14
 */
public interface IObserver<E> {

    void update(E event);

}
