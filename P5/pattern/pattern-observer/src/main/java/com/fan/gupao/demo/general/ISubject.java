package com.fan.gupao.demo.general;

/**
 * 抽象主题者
 * @author 樊高风
 * @date 2020/8/14
 */
public interface ISubject<E> {

    boolean attach(IObserver<E> observer);

    boolean detach(IObserver<E> observer);

    void notify(E event);

}
