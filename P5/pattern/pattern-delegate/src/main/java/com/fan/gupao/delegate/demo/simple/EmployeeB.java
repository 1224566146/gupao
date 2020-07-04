package com.fan.gupao.delegate.demo.simple;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class EmployeeB implements IEmployee {

    protected String goodAt = "平面设计";
    @Override
    public void doing(String task) {
        System.out.println("我是员工B,我擅长"+goodAt+",现在开始做"+task+"工作");
    }
}
