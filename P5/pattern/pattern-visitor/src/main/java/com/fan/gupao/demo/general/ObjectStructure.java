package com.fan.gupao.demo.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象
 * @author 樊高风
 * @date 2020/8/14
 */
public class ObjectStructure {


    private List<IElement> list = new ArrayList<>();

    {
        this.list.add(new ConcreteElementA());
        this.list.add(new ConcreteElementB());
    }

    public void accept(IVisitor iVisitor){
        for (IElement iElement : list) {
            iElement.accept(iVisitor);
        }
    }

}
