package com.fan.gupao.pattern.factory.abstractfactory;

import com.fan.gupao.pattern.factory.ICourse;

/**
 * @Description: 抽象工厂设计模式（父类）
 * @Author: 樊高风
 * @Date: 15:24 2020/2/11
 */
public abstract interface CourseFactory {

    ICourse createCourse();

    INote createNote();

    IVideo createVideo();

}
