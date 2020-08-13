package com.fan.gupao.demo.calculate;

/**
 * @author 樊高风
 * @date 2020/8/13
 */
public abstract class AbstractInterpreter implements IArithmeticInterpreter {

    protected IArithmeticInterpreter left;
    protected IArithmeticInterpreter right;

    public AbstractInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }
}
