package com.fan.gupao.demo.general;

/**
 * 非终结符表达式
 * @author 樊高风
 * @date 2020/8/13
 */
public class NonterminalExpression implements IExpression {

    private IExpression[] expressions;

    public NonterminalExpression(IExpression... expressions) {
        // 每个非终结符表达式都会对其他表达式产生依赖
        this.expressions = expressions;
    }

    @Override
    public Object interpret(Context context) {
        // 进行文法处理
        context.put("", "");
        return null;
    }
}
