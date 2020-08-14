package com.fan.gupao.demo.kpi;

import java.util.Random;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }


    // 考核的是每年新产品研发数量
    public int getProducts(){
        return new Random().nextInt(10);
    }
}
