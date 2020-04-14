package com.fan.gupao.demo.annotaions.configures.imports;

import com.fan.gupao.project.entity.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:23 2020/4/14
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @authorer: 樊高风
     * @date: 2020/4/14 11:23
     * @param annotationMetadata
     *              当前类的注解信息
     * @param beanDefinitionRegistry
     *              完成BeanDefinition的注册
     * @return:
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean company = beanDefinitionRegistry.containsBeanDefinition("com.fan.gupao.project.entity.Company");
        boolean member = beanDefinitionRegistry.containsBeanDefinition("com.fan.gupao.project.entity.Member");
        if(company && member){
            BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
            beanDefinitionRegistry.registerBeanDefinition("user", beanDefinition);
        }
    }
}
