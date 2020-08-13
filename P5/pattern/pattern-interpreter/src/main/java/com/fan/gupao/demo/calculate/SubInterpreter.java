package com.fan.gupao.demo.calculate;

/**
 * @author 樊高风
 * @date 2020/8/13
 */
public class SubInterpreter extends AbstractInterpreter {
    public SubInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }
}
