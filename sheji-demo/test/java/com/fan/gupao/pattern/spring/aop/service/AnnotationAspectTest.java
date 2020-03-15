package com.fan.gupao.pattern.spring.aop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:29 2020/3/12
 */
@SpringBootTest
public class AnnotationAspectTest {


    @Autowired
    private MemberService memberService;


    @Test
    public void testGet(){
        memberService.get();
    }


}
