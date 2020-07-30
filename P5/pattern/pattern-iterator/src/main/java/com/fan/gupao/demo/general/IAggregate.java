package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
// 抽象容器
public interface IAggregate<E> {

    boolean add(E element);

    boolean remove(E element);

    Iterator<E> iterator();

}
