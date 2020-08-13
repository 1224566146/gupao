package com.fan.gupao.demo.general;

/**
 * 抽象表达式
 * @author 樊高风
 * @date 2020/8/13
 */
public interface IExpression {

    // 对表达式进行解释
    Object interpret(Context context);

}
