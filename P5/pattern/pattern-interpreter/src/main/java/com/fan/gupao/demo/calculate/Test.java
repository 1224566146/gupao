package com.fan.gupao.demo.calculate;

/**
 * @author 樊高风
 * @date 2020/8/13
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("result:"+ new GPCalculator("10 + 30").calculate());
        System.out.println("result:"+ new GPCalculator("10 + 30 - 20").calculate());
        System.out.println("result:"+ new GPCalculator("100 * 2 + 400 * 1 + 66").calculate());

    }
}
