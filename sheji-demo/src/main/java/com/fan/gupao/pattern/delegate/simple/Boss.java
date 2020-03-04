package com.fan.gupao.pattern.delegate.simple;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:37 2020/3/4
 */
public class Boss {

    public void command(String command,Leader leader){
        leader.doing(command);
    }

}
