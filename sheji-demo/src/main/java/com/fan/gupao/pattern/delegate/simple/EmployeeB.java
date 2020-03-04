package com.fan.gupao.pattern.delegate.simple;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:36 2020/3/4
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我现在开始干"+command+"工作");
    }
}
