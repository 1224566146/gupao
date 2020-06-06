package com.fan.gupao.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 樊高风
 * @Title: FinalDemo
 * @ProjectName p5-practice
 * @Description: FinalDemo
 * @date 2020/6/6 14:32
 */
public class FinalDemo {

    private final Map<String,String> states;

    public FinalDemo() {
        states = new HashMap<>();
        states.put("key", "樊高风");
    }
}
