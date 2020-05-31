package com.fan.gupao.pattern.factory.abstractfactory;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:29 2020/2/11
 */
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("编辑Java笔记");
    }
}
