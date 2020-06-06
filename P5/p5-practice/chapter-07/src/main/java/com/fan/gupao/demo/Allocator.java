package com.fan.gupao.demo;

import java.util.ArrayList;
import java.util.List;

public class Allocator {

    private List<Object> list=new ArrayList<>();
    /**
     * 申请资源
     * @param from
     * @param to
     * @return
     */
    synchronized boolean apply(Object from,Object to){
        if(list.contains(from)||list.contains(to)){
            return false;
        }else {
            list.add(from);
            list.add(to);
            return true;
        }
    }
    synchronized void free(Object from,Object to){
        list.remove(from);
        list.remove(to);
    }
}
