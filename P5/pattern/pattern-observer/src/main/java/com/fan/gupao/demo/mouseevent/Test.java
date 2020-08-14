package com.fan.gupao.demo.mouseevent;

import com.fan.gupao.demo.mouseevent.core.EventListener;
import com.fan.gupao.demo.mouseevent.handler.Mouse;
import com.fan.gupao.demo.mouseevent.handler.MouseEventListener;
import com.fan.gupao.demo.mouseevent.handler.MouseEventType;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Test {

    public static void main(String[] args) {

        EventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, listener);
        mouse.addListener(MouseEventType.ON_MOVE, listener);

        mouse.click();
        mouse.move();

    }
}
