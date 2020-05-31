package com.fan.gupao.demo3;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:27 2020/5/31
 */
public class Person2<T> {

    private T identityCard;

    public void talk(String something){
        System.out.println("我正在说:"+something);
    }

    public Person2(T identityCard) {
        this.identityCard = identityCard;
    }
}
