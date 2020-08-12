package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class ConcreteColleagueA extends Colleague {


    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
        this.mediator.setColleagueA(this);
    }

    // 自有方法
    public void selfMethodA(){
        // 处理自己的逻辑
        System.out.println(String.format("%s:self-Method",this.getClass().getSimpleName()));
    }


    // 依赖方法
    public void depMethodA(){
        // 处理自己的逻辑
        System.out.println(String.format("%s:depMethod:delegate to Mediator:",this.getClass().getSimpleName()));
        // 无法处理的业务逻辑委托给中介者处理
        this.mediator.transferA();
    }
}
