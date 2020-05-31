package com.fan.gupao.demo.annotaions.configures.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:50 2020/4/14
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //从IOC容器中拿到已经实例化的对象
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        Environment environment = conditionContext.getEnvironment();

        String property = environment.getProperty("os.name");
        System.out.println(property);
        if(property.contains("Linux")){
            return true;
        }

        return false;
    }
}
