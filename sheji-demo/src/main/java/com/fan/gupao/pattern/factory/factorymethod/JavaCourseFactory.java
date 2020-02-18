package com.fan.gupao.pattern.factory.factorymethod;

import com.fan.gupao.pattern.factory.ICourse;
import com.fan.gupao.pattern.factory.JavaCourse;

/**
 * @Description: 工厂方法模式（子类）
 * @Author: 樊高风
 * @Date: 14:57 2020/2/11
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
