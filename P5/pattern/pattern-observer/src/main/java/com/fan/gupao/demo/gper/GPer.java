package com.fan.gupao.demo.gper;

import java.util.Observable;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class GPer extends Observable {


    private String name = "GPer生态圈";
    private static final GPer G_PER = new GPer();

    private GPer(){}

    public static GPer getInstance(){
        return G_PER;
    }

    public String getName() {
        return name;
    }


    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+"在"+this.name+"上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
