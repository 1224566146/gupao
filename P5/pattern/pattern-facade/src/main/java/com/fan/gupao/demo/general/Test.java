package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/6/23 16:27
 */
public class Test {

    // 客户
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}
