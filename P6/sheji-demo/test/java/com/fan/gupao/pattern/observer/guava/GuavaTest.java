package com.fan.gupao.pattern.observer.guava;

import com.fan.gupao.pattern.observer.gperadvice.Question;
import com.google.common.eventbus.EventBus;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:23 2020/3/9
 */
public class GuavaTest {

    public static void main(String[] args) {


        //消息总线
        EventBus eventBus = new EventBus();
//        GuavaEvent guavaEvent = new GuavaEvent();
//        eventBus.register(guavaEvent);

        Question question = new Question();
        question.setUserName("小明");
        question.setContent("为什么");

        GPer gPer = GPer.getInstance();
        Teacher teacher = new Teacher("樊高风");

        eventBus.register(teacher);
        eventBus.register(gPer);

        eventBus.post(question);


//        eventBus.post("樊高风");

        //从Struts到SpringMVC的升级
        //因为Struts面向的类，而SpringMVC面向的是方法

        //前面两者面向的是类，Guava面向是方法

        //能够轻松落地观察模式的一种解决方法
        //MQ


    }
}
