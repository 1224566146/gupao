package com.fan.gupao.transaction.service;

import com.alibaba.fastjson.JSON;
import com.fan.gupao.transaction.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:19 2020/5/2
 */
@ContextConfiguration(locations = {"classpath*:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
//    @Ignore
    public void queryAll(){
        try{
            List<Member> list = memberService.queryAll();
            System.out.println(JSON.toJSONString(list,true));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
//    @Ignore
    public void testRemove(){
        try{
            boolean r = memberService.remove(2L);
            System.out.println(r);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
//    @Ignore
    public void testLogin(){
        try{
            memberService.login(3L, "樊高风");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd(){
        try{
            Member member = new Member("樊高风","北京",18);
            memberService.add(member);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
