package com.fan.gupao.pattern.observer.guava;

import com.fan.gupao.pattern.observer.gperadvice.Question;
import com.google.common.eventbus.Subscribe;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:04 2020/3/10
 */
public class GPer {

    private GPer(){

    }

    private static GPer gPer = null;

    public static GPer getInstance(){
        if(gPer == null){
            gPer = new GPer();
        }
        return gPer;
    }

    private String name = "GPer生态圈";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Subscribe
    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+"在"+this.name+"上提交了一个问题。");
    }

}
