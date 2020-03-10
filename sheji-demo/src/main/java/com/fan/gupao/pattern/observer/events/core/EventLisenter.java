package com.fan.gupao.pattern.observer.events.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 监听者，它就是观察者
 * @Author: 樊高风
 * @Date: 20:37 2020/3/9
 */
public class EventLisenter {


    //JDK底层的lisenter通常也是这样来设计的
    protected Map<String,Event> events = new HashMap<>();


    //事件名称和一个目标对象来触发事件
    public void addLisenter(String eventType,Object target){
        try {
            this.addLisenter(eventType, target,target.getClass().getMethod("on"+toUpperFirstCase(eventType),Event.class));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addLisenter(String evetnType, Object target, Method callback){
        //注册事件
        events.put(evetnType, new Event(target, callback));
    };


    //触发，只要有动作就触发
    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {

            //发起回调
            if(event.getCallback() != null){
                //用反射调用它的回调函数
                event.getCallback().invoke(event.getTarget(), event);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //事件名称触发
    protected void trigger(String trigger){
        if(!this.events.containsKey(trigger)){
            return;
        }
        trigger(this.events.get(trigger).setTigger(trigger));
    }



    private String toUpperFirstCase(String eventType) {
        char [] chars = eventType.toCharArray();
        chars[0] -=32;
        return String.valueOf(chars);
    }


}
