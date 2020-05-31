package com.fan.gupao.pattern.observer.events.mouseevent;

import com.fan.gupao.pattern.observer.events.core.EventLisenter;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:02 2020/3/9
 */
public class Keybord extends EventLisenter {

    public void click(){
        System.out.println("调用键盘单击");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void up(){
        System.out.println("调用键盘弹起");
        this.trigger(MouseEventType.ON_UP);
    }
}
