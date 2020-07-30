package com.fan.gupao.demo.general;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
// 具体迭代器
public class ConcreteIterator<E> implements Iterator<E> {

    private List<E> list;

    private int cursor = 0;

    public ConcreteIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        return this.list.get(this.cursor++);
    }

    @Override
    public boolean hasNext() {
        return this.cursor != list.size();
    }
}
