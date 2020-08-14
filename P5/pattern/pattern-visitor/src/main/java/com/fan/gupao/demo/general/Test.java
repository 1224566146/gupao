package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Test {


    public static void main(String[] args) {


        ObjectStructure collection = new ObjectStructure();
        System.out.println("Concrete VisitorA handle elements:");
        IVisitor visitorA = new ConcreteVisitorA();
        collection.accept(visitorA);

        System.out.println("---------------------------");
        System.out.println("Concrete VisitorB handle elements:");
        IVisitor visitorB = new ConcreteVisitorB();
        collection.accept(visitorB);


    }

}
