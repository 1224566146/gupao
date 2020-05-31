package com.fan.gupao.demo.annotaions.configures.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:20 2020/4/14
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                "com.fan.gupao.project.entity.Company",
                "com.fan.gupao.project.entity.Member"
        };
    }
}
