package com.fan.gupao.pattern.prototype.simple;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:19 2020/2/19
 */
public class Client {

    private Prototype prototype;

    public Prototype startClone(Prototype concretePrototype){
        return concretePrototype.clone();
    }

}
