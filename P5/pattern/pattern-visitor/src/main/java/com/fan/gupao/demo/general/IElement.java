package com.fan.gupao.demo.general;

/**
 * 抽象元素
 * @author 樊高风
 * @date 2020/8/14
 */
public interface IElement {

    void accept(IVisitor visitor);

}
