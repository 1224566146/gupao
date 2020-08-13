package com.fan.gupao.demo.calculate;

/**
 * @author 樊高风
 * @date 2020/8/13
 */
public class NumInterpreter implements IArithmeticInterpreter {

    private int value;

    public NumInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
