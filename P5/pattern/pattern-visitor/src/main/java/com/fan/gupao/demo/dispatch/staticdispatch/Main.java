package com.fan.gupao.demo.dispatch.staticdispatch;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Main {


    public void test(String string){
        System.out.println("String:"+string);
    }

    public void test(Integer integer){
        System.out.println("integer:"+integer);
    }

    public static void main(String[] args) {

        String string = "1";
        Integer integer = 1;
        Main main = new Main();
        main.test(string);
        main.test(integer);

    }

}
