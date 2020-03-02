package com.fan.gupao.pattern.proxy.staticproxy;

import com.fan.gupao.pattern.proxy.Person;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:26 2020/3/2
 */
public class Father implements Person {

    private Son person;

    public Father(Son person){
        this.person = person;
    }


    @Override
    public void findLove() {
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意,确立关系");
    }

    public void findJob(){
        System.out.println("父亲开始找工作");
        this.person.findJob();
        System.out.println("开始工作");
    }
}
