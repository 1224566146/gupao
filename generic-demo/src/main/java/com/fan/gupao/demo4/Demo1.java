package com.fan.gupao.demo4;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:31 2020/5/31
 */
public class Demo1<T,K> {

    public T method1(T t,K k){
        //TODO...
        return null;
    }

    public <Y> K method2(Y y){
        return null;
    }

    public static <J> void method3(J j){
        //TODO...
    }

//    public static void method4(K k){
//        // TODO....
//    }

    public static void main(String[] args) {

        Demo1<String,String> demo1 = new Demo1<>();
        demo1.method2("12312");


    }

}
