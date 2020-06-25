package com.fan.gupao.demo.demo01;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
public class GpCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if(1==2){
            return true;
        }else{
            return false;
        }
    }
}
