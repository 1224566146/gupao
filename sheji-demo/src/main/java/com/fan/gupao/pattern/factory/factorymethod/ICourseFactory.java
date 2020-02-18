package com.fan.gupao.pattern.factory.factorymethod;

import com.fan.gupao.pattern.factory.ICourse;

/**
 * @Description: 工厂方法设计模式（父类）
 * @Author: 樊高风
 * @Date: 14:55 2020/2/11
 */
public interface ICourseFactory {
    ICourse create();
}
