package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class Test {

    public static void main(String[] args) {


        Mediator mediator= new ConcreteMediator();
        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(mediator);
        concreteColleagueA.depMethodA();

        System.out.println("-------------------------------");
        concreteColleagueB.depMethodB();

    }
}
