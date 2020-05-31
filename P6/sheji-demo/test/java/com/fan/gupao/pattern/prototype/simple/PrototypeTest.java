package com.fan.gupao.pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:23 2020/2/19
 */
public class PrototypeTest {

    public static void main(String[] args) {

        //创建一个具体的需要克隆的对象
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        //填充属性，方便测试
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("Xiang");
        List hobbies = new ArrayList();
        hobbies.add("篮球");
        hobbies.add("足球");
        concretePrototypeA.setHobbies(hobbies);

        //创建clien对象，准备开始克隆
        Client client = new Client();
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println("克隆对象的地址:"+concretePrototypeClone);
        System.out.println("原对象的地址:"+concretePrototypeA);
        List hobbies1 = concretePrototypeClone.getHobbies();
        hobbies1.add("灌篮");
        concretePrototypeClone.setHobbies(hobbies1);
        String name = concretePrototypeClone.getName();
        name = "123";
        concretePrototypeClone.setName(name);

        System.out.println("克隆对象中的引用类型地址值:"+concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址值:"+concretePrototypeA.getHobbies());
        System.out.println("对象地址比较:"+(concretePrototypeA.getHobbies() == concretePrototypeClone.getHobbies()));

        System.out.println("克隆对象中的值类型地址值:"+concretePrototypeClone.getName());
        System.out.println("原对象中的值类型地址值:"+concretePrototypeA.getName());
        System.out.println("对象地址比较:"+(concretePrototypeA.getName() == concretePrototypeClone.getName()));

    }
}
