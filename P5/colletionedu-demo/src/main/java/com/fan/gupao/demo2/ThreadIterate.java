package com.fan.gupao.demo2;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:08 2020/5/27
 */
public class ThreadIterate extends Thread {

    private List list;

    public ThreadIterate(List list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            for (Iterator iterator = list.iterator(); iterator.hasNext();){
                iterator.next();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
