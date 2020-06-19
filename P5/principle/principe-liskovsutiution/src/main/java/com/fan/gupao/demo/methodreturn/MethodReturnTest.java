package com.fan.gupao.demo.methodreturn;

/**
 * @author 樊高风
 * @date 2020/6/19 21:09
 */
public class MethodReturnTest {

    public static void main(String[] args) {

        Base child = new Child();
        System.out.println(child.method());
    }
}
