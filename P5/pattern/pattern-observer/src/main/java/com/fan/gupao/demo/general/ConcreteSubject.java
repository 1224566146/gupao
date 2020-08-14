package com.fan.gupao.demo.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题者
 * @author 樊高风
 * @date 2020/8/14
 */
public class ConcreteSubject<E> implements ISubject<E> {


    private List<IObserver<E>> observers = new ArrayList<>();

    @Override
    public boolean attach(IObserver<E> observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    @Override
    public boolean detach(IObserver<E> observer) {
        return this.observers.remove(observer);
    }

    @Override
    public void notify(E event) {
        for (IObserver<E> observer : observers) {
            observer.update(event);
        }
    }
}
