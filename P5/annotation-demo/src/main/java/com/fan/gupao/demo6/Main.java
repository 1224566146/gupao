package com.fan.gupao.demo6;


public class Main {

    public static void main(String[] args) {

        System.out.println(Father.class.isAnnotationPresent(MySimpleAnno.class));

        System.out.println(Son.class.isAnnotationPresent(MySimpleAnno.class));

    }
}
