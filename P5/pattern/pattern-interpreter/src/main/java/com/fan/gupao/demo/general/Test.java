package com.fan.gupao.demo.general;

import java.util.Stack;

/**
 * @author 樊高风
 * @date 2020/8/13
 */
public class Test {

    public static void main(String[] args) {


        try {
            Context context = new Context();
            // 定义一个语法容器,用于存储一个具体表达式
            Stack<IExpression> stack = new Stack<>();
//            for (){
//                // 进行语法解析,并产生递归调用
//            }
            // 获取得到最终的解析表达式:完整语法树
            IExpression pop = stack.pop();
            // 递归调用获取结果
            pop.interpret(context);
        }catch (Exception e){

        }

    }

}
