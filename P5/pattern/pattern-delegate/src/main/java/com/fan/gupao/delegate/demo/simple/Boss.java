package com.fan.gupao.delegate.demo.simple;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class Boss {

    public void command(String task,Leader leader){
        leader.doing(task);
    }
}
