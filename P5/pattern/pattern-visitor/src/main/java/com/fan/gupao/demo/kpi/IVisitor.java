package com.fan.gupao.demo.kpi;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public interface IVisitor {

    void visit(Engineer engineer);

    void visit(Manager manager);

}
