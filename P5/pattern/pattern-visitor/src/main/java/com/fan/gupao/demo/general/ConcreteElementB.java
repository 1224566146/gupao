package com.fan.gupao.demo.general;

/**
 * 具体元素
 * @author 樊高风
 * @date 2020/8/14
 */
public class ConcreteElementB implements IElement {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String operationB(){
        return this.getClass().getSimpleName();
    }
}
