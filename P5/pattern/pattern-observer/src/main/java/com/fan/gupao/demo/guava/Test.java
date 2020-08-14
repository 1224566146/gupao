package com.fan.gupao.demo.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Test {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();

        PojoEvent pojoEvent = new PojoEvent();
        VoEvent voEvent = new VoEvent();
        eventBus.register(pojoEvent);
        eventBus.register(voEvent);

        eventBus.post(new Pojo("Tom"));

    }

}
