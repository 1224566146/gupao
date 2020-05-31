package com.fan.gupao.pattern.observer.guava;

import com.fan.gupao.pattern.observer.gperadvice.Question;
import com.google.common.eventbus.Subscribe;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:18 2020/3/10
 */
public class Teacher {

    private String name;


    @Subscribe
    public void update(Question question){
        System.out.println("=================================================");
        System.out.println(name+"老师，你好!\n"+
                "您收到了一个来自“"+question.getUserName()+"”的提问，希望您解答，问题内容如下:\n"+
                question.getContent()+"\n"+
                "提问者："+question.getUserName());
    }

    public Teacher(String name) {
        this.name = name;
    }
}
