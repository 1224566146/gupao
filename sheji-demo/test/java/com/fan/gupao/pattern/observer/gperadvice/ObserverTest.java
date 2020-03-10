package com.fan.gupao.pattern.observer.gperadvice;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:33 2020/3/9
 */
public class ObserverTest {

    public static void main(String[] args) {

        Question question = new Question();
        question.setUserName("小明");
        question.setContent("为什么？？？？？");

        GPer gPer = GPer.getInstance();
        Teacher teacher = new Teacher("樊高风");

        gPer.addObserver(teacher);
        gPer.publishQuestion(question);

    }
}
