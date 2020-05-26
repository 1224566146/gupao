package com.fan.gupao.demo5;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:50 2020/5/26
 */
public class A {

    public A(){
        System.out.println("A 无参构造器被调用了");
    }

    public static B createBObj(){
        System.out.println("A 的静态方法createBObj被调用了");
        return new B();
    }

    public C createCObj(){
        System.out.println("A 的实例方法createCObj被调用了");
        return new C();
    }
}
