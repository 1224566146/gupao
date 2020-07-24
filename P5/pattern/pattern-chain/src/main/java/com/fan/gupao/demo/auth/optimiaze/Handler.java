package com.fan.gupao.demo.auth.optimiaze;

import com.fan.gupao.demo.auth.Member;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);
}
