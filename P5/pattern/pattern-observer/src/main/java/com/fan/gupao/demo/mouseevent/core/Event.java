package com.fan.gupao.demo.mouseevent.core;


import java.lang.reflect.Method;

/**
 * 标准事件源格式的定义
 * @author 樊高风
 * @date 2020/8/14
 */
public class Event {

    // 事件源,动作是由谁发出的
    private Object source;
    // 事件触发,要通知谁(观察者)
    private EventListener target;
    // 观察者给的回应
    private Method callback;
    // 事件的名称
    private String trigger;
    // 事件的触发事件
    private long time;

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public EventListener getTarget() {
        return target;
    }

    public void setTarget(EventListener target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
