package com.fan.gupao.springcloud.demo.demo02;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(GpImportBeanDefinitionRegistrar.class)
public @interface EnableGpRegistrara {
}
