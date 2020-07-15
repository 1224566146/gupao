package com.fan.gupao.demo.general;

/**
 * 上下文环境
 * @author 樊高风
 * @date 2020/7/15
 */
public class Context {

    private IStrategy mStrategy;

    public Context(IStrategy mStrategy) {
        this.mStrategy = mStrategy;
    }

    public void algorithm(){
        this.mStrategy.algorithm();
    }
}
