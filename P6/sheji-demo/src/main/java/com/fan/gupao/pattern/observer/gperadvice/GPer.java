package com.fan.gupao.pattern.observer.gperadvice;

import java.util.Observable;

/**
 * @Description: JDK提供的一种观察者的实现方法，被观察者
 * @Author: 樊高风
 * @Date: 15:01 2020/3/9
 */
public class GPer extends Observable {


    private String name = "GPer生态圈";

    private static GPer gPer = null;

    private GPer(){

    }

    public static GPer getInstance(){
        if(gPer == null){
            gPer = new GPer();
        }
        return gPer;
    }


    public String getName(){
        return name;
    }


    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+"在"+this.name+"上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }



}
