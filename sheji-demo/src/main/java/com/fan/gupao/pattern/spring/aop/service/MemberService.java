package com.fan.gupao.pattern.spring.aop.service;

import com.fan.gupao.pattern.spring.aop.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: 注解版业务操作类
 * @Author: 樊高风
 * @Date: 15:58 2020/3/12
 */
@Service
@Slf4j
public class MemberService {


    public Member get(long id){
        System.out.println("getMenmberById method.......");
        return new Member();
    }

    public Member get(){
        System.out.println("getMember method . . .");
        return new Member();
    }

    public void save(Member member){
        System.out.println("save member method . . .");
    }

    public boolean delete(long id) throws Exception{
        System.out.println("delete method . . .");
        throw new Exception("spring aop ThrowAdvice演示");
    }

}
