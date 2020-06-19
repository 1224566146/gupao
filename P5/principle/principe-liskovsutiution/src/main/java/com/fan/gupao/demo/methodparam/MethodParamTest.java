package com.fan.gupao.demo.methodparam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 樊高风
 * @date 2020/6/19 21:04
 */
public class MethodParamTest {

    public static void main(String[] args) {
        Base child = new Child();
        Map map = new HashMap();
        child.method(map);
    }
}
