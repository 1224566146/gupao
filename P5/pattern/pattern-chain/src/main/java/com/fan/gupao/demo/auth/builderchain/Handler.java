package com.fan.gupao.demo.auth.builderchain;

import com.fan.gupao.demo.auth.Member;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public abstract class Handler<T> {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);

    public static class Builder<T>{

        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler handler){
            if(this.head == null){
                this.head = this.tail = handler;
                return this;
            }
            this.tail.setNext(handler);
            this.tail = handler;
            return this;
        }

        public Handler<T> build(){
            return this.head;
        }

    }
}
