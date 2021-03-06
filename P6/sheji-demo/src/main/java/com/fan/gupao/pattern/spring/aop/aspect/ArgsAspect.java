package com.fan.gupao.pattern.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *  @Description:
 * @Author: 樊高风
 * @Date: 17:04 2020/3/12
 */
@Component
@Slf4j
@Aspect
public class ArgsAspect {


    //配置切入点，该方法无方法体，主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.fan.gupao.pattern.spring.aop.service..*(..))")
    public void aspect(){}

    //配置前置通知，拦截返回值com.fan.gupao.pattern.spring.aop.model.Member的方法
    @Before("execution(com.fan.gupao.pattern.spring.aop.model.Member com.fan.gupao.pattern.spring.aop.service..*(..))")
    public void beforeReturnUser(JoinPoint joinPoint){
        System.out.println("beforeReturnUser"+joinPoint);
    }


    //配置前置通知，拦截参数尾
    @Before("execution(* com.fan.gupao.pattern.spring.aop.service..*(com.fan.gupao.pattern.spring.aop.model.Member))")
    public void beforeArgUser(JoinPoint joinPoint){
        System.out.println("beforeArgUser"+joinPoint);
    }


    //配置前置通知，拦截含有long类型参数的方法，并将参数值注入到当前方法的形参id中
    @Before("aspect()&&args(id)")
    public void beforeArgId(JoinPoint joinPoint,long id){
        System.out.println("beforeArgId"+joinPoint+"\tId"+id);
    }



}
