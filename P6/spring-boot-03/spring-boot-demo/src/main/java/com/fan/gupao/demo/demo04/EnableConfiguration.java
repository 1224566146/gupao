package com.fan.gupao.demo.demo04;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(GpDefineImportSelector.class)
public @interface EnableConfiguration {
}
