package com.fan.gupao.demo.annotaions.configures.imports;

import com.fan.gupao.project.entity.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:06 2020/4/14
 */
public class MyFactoryBean implements FactoryBean<Monkey> {
    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
