package com.fan.gupao.pattern.prototype.simple;

import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:16 2020/2/19
 */
public class ConcretePrototypeA implements Prototype {

    private int age;

    private String name;

    private List hobbies;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(this.age);
        concretePrototypeA.setName(this.name);
        concretePrototypeA.setHobbies(this.hobbies);
        return concretePrototypeA;
    }
}
