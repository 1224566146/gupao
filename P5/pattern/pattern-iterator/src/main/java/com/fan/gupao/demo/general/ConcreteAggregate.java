package com.fan.gupao.demo.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
// 具体容器
public class ConcreteAggregate<E> implements IAggregate<E>  {


    private List<E> list = new ArrayList<>();

    @Override
    public boolean add(E element) {
        return this.list.add(element);
    }

    @Override
    public boolean remove(E element) {
        return this.list.remove(element);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(this.list);
    }
}
