package com.fan.gupao.demo.md5;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author 樊高风
 * @date 2020/8/17
 */
public class Md5Test {
    public static void main(String[] args) {

        // sale:盐
        Md5Hash md5Hash = new Md5Hash("123456","aaa",1024);
        System.out.println(md5Hash);

    }
}
