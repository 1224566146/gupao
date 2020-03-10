package com.fan.gupao.pattern.observer.events;

import com.fan.gupao.pattern.observer.events.mouseevent.Keybord;
import com.fan.gupao.pattern.observer.events.mouseevent.Mouse;
import com.fan.gupao.pattern.observer.events.mouseevent.MouseEventCallback;
import com.fan.gupao.pattern.observer.events.mouseevent.MouseEventType;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:06 2020/3/9
 */
public class MouseEventTest {

    public static void main(String[] args) {

        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        Keybord keybord = new Keybord();

        keybord.addLisenter(MouseEventType.ON_CLICK, callback);
        keybord.click();

        //@谁？  @回调方法
        mouse.addLisenter(MouseEventType.ON_CLICK, callback);

        mouse.click();

    }
}
