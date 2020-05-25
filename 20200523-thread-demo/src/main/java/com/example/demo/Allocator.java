package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:46 2020/5/25
 */
public class Allocator {

    private List<Object> list = new ArrayList<>();
    synchronized boolean apply(Object from, Object to){
        if(list.contains(from) || list.contains(to)){
            return false;
        }
        list.add(from);
        list.add(to);
        return true;
    }

    synchronized void free(Object from, Object to){
        list.remove(from);
        list.remove(to);
    }

}
