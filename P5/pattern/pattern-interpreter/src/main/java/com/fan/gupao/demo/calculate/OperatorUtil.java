package com.fan.gupao.demo.calculate;

/**
 * @author 樊高风
 * @date 2020/8/13
 */
public class OperatorUtil {


    public static boolean isOperator(String symbol){
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
    }


    public static AbstractInterpreter getInterpreter(IArithmeticInterpreter left,IArithmeticInterpreter right,String symbol){
        if(symbol.equals("+")){
            return new AddInterpreter(left, right);
        }else if(symbol.equals("-")){
            return new SubInterpreter(left, right);
        }else if(symbol.equals("*")){
            return new MultiInterpreter(left, right);
        }else if(symbol.equals("/")){
            return new DivInterpreter(left, right);
        }
        return null;
    }

}
