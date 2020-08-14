package com.fan.gupao.demo.kpi;

import java.util.Random;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Engineer extends Employee {
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }


    // 考核指标是每年的代码量
    public int getCodeLines(){
        return new Random().nextInt(10 * 10000);
    }
}
