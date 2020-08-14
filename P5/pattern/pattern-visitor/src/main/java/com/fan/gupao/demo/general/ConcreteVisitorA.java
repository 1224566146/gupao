package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class ConcreteVisitorA implements IVisitor {
    @Override
    public void visit(ConcreteElementA element) {
        String result = element.operationA();
        System.out.println("result from "+element.getClass().getSimpleName()+":"+result);
    }

    @Override
    public void visit(ConcreteElementB element) {
        String result = element.operationB();
        System.out.println("result from "+element.getClass().getSimpleName()+":"+result);
    }
}
