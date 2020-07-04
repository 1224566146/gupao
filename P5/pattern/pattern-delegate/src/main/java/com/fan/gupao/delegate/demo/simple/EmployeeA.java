package com.fan.gupao.delegate.demo.simple;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class EmployeeA implements IEmployee {

    protected String goodAt = "编程";
    @Override
    public void doing(String task) {
        System.out.println("我是员工A,我擅长"+goodAt+",现在开始做"+task+"工作");
    }
}
