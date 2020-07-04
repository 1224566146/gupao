package com.fan.gupao.delegate.demo.general;

import java.util.Random;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class Delegate implements Task {



    @Override
    public void doTask() {

        System.out.println("代理执行开始...");

        Task task = null;
        if(new Random().nextBoolean()){
            task = new ConcreteA();
            task.doTask();
        }else{
            task = new ConcreteB();
            task.doTask();
        }

        System.out.println("代理执行完毕...");
    }
}
