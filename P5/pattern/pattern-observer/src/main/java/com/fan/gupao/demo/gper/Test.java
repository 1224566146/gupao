package com.fan.gupao.demo.gper;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Test {

    public static void main(String[] args) {

        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("jerry");

        gPer.addObserver(tom);
        gPer.addObserver(jerry);

        // 用户行为
        Question question = new Question();
        question.setContent("观察者模式适用于哪些场景?");
        question.setUserName("张三");

        gPer.publishQuestion(question);

    }
}
