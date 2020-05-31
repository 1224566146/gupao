package com.fan.gupao.pattern.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:08 2020/3/12
 */
//声明这是一个切面Bean
@Aspect
@Slf4j
//声明这是一个组件
@Component
public class AnnotaionAspect {

    //配置切入点，该方法无方法体，主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.fan.gupao.pattern.spring.aop.service..*(..))")
    public void aspect(){}

    /**
     * 功能描述:配置前置通知，使用在方法aspect（）上注册的切入点
     * 同时接受JoinPoint切入点对象，可以没有该参数
     * @authorer: 樊高风 
     * @date: 2020/3/12 16:11
     * @param:  
     * @return:  
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("before通知"+joinPoint);
    }


    //配置后置通知，使用在方法aspect（）上注册的切入点
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        System.out.println("after通知"+joinPoint);
    }


    //配置环绕通知，使用在方法aspect（）上注册的切入点
    @Around("aspect()")
    public void around(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        System.out.println("输出around时间:"+start);
        try {
            ((ProceedingJoinPoint)joinPoint).proceed();

            long end = System.currentTimeMillis();
            System.out.println("around通知"+joinPoint+"\tUse Time:"+(end-start)+"ms!");

        }catch (Throwable e){

            long end = System.currentTimeMillis();
            System.out.println("around通知"+joinPoint+"\tUse Time:"+(end-start)+"ms with exception:"+e.getMessage());
        }
    }


    //配置后置返回通知，使用在方法aspect（）上注册的切入点
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("afterReturn通知"+joinPoint);
    }


    //配置抛出异常后通知，使用在方法aspect（）上注册的切入点
    @AfterThrowing(pointcut = "aspect()",throwing = "ex")
    public void afterThrow(JoinPoint joinPoint,Exception ex){
        System.out.println("afterThrow通知"+joinPoint+"\t"+ex.getMessage());
    }

}
