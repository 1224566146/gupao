package com.fan.gupao.demo.demo04;

import com.fan.gupao.demo.demo02.RedisConfiguration;
import com.fan.gupao.demo.demo03.MybatisConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
public class GpDefineImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 动态导入bean,告诉了Spring,两个配置类在哪里
        // TODO 在这里去加载所有的配置类就行?
        // 通过某种机制去完成指定路径的配置类的扫描就行?
        // package.class.className
        return new String[]{
            MybatisConfiguration.class.getName(),
        RedisConfiguration.class.getName()};
    }
}
