package com.fan.gupao.spring.framework.aop;

import com.fan.gupao.spring.framework.aop.support.GPAdvisedSupport;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:59 2020/4/27
 */
public class GPDefaultAopProxyFactory {
    public GPAopProxy createAopProxy(GPAdvisedSupport config) {

        Class targetClass = config.getTargetClass();
        if(targetClass.getInterfaces().length>0){
            return new GPJdkDynamicAopProxy(config);
        }
        return new GPCglibAopProxy();
    }
}
