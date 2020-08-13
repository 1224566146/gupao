package com.fan.gupao.demo.general;

/**
 * 终结符表达式
 * @author 樊高风
 * @date 2020/8/13
 */
public class TerminalExpression implements IExpression {


    private Object value;


    @Override
    public Object interpret(Context context) {
        // 实现文法中与终结符有关的操作
        context.put("", "");
        return null;
    }
}
