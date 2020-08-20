package com.fan.gupao.demo.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class EncoderTest {

    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));

    }
}
