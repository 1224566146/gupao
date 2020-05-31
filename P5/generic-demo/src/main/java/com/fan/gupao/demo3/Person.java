package com.fan.gupao.demo3;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:27 2020/5/31
 */
public class Person {

    private String identityCard;

    public void talk(String something){
        System.out.println("我正在说:"+something);
    }

    public Person(String identityCard) {
        this.identityCard = identityCard;
    }
}
