package com.fan.gupao.demo.calculate;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author 樊高风
 * @date 2020/8/13
 */
public class SpringTest {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("1000 * 2+400*1+66");
        Integer value = (Integer) expression.getValue();
        System.out.println("计算结果是:"+ value);

    }
}
