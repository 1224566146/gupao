package com.fan.gupao.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:34 2020/5/27
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        testForAndIterator();
    }

    public static void testRandomAccess() {

        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10000000; i++) {
            arrayList.add("even-" + i);
            linkedList.add("even-" + i);
        }

        long startTime = System.currentTimeMillis();

        // 二分查找的方法... 下标
        Collections.binarySearch(arrayList, "even-" + 4123123);

        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList的二分查找:" + (endTime - startTime));

        startTime = System.currentTimeMillis();

        // 二分查找的方法... 下标
        Collections.binarySearch(linkedList, "even-" + 4123123);

        endTime = System.currentTimeMillis();
        System.out.println("LinkedList的二分查找:" + (endTime - startTime));

    }


    public static void testForAndIterator(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i <arrayList.size() ; i++) {
            arrayList.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for循环 : "+(endTime-startTime));


        startTime = System.currentTimeMillis();
        for ( Iterator iterator =arrayList.iterator(); iterator.hasNext();){
            iterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Iterator循环："+(endTime - startTime));
    }

}
