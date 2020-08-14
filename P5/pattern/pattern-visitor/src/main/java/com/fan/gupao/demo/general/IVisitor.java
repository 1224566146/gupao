package com.fan.gupao.demo.general;

/**
 * 抽象访问者
 * @author 樊高风
 * @date 2020/8/14
 */
public interface IVisitor {

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);

}
