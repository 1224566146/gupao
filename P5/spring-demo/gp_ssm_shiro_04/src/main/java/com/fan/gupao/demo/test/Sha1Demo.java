package com.fan.gupao.demo.test;

import org.apache.shiro.crypto.hash.Sha1Hash;

/**
 * @author 樊高风
 * @date 2020/8/19
 */
public class Sha1Demo {

    public static void main(String[] args) {

        Sha1Hash s1 = new Sha1Hash("654321","aaa",1024);
        System.out.println(s1);

    }
}
