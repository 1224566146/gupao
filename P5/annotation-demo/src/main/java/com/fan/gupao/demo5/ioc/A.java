package com.fan.gupao.demo5.ioc;

import com.fan.gupao.demo5.anno.SevenBean;
import com.fan.gupao.demo5.anno.SevenComponent;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:18 2020/5/31
 */
@SevenComponent
public class A {

    public A(){
        System.out.println("A 无参构造器被调用了");
    }

    @SevenBean("b")
    public static B createBObj(){
        System.out.println("A 的静态方法 createBObj 被调用了");
        return new B();
    }

    @SevenBean("c")
    public C createCObj(){
        System.out.println("A 的实例方法 createCObj 被调用了");
        return new C();
    }
}
