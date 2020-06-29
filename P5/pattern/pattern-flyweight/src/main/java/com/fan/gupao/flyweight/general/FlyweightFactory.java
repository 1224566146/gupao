package com.fan.gupao.flyweight.general;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * @author 樊高风
 * @date 2020/6/28
 */
public class FlyweightFactory {

    private static Map<String,IFlyweight> pool = new HashMap<>();

    // 因为内部状态具备不变性,因此作为缓存的键
    public static IFlyweight getFlyweight(String intrinsicState){
        if(!pool.containsKey(intrinsicState)){
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState, flyweight);
        }
        return pool.get(intrinsicState);
    }
}
