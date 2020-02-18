package com.fan.gupao.pattern.factory.abstractfactory;

import com.fan.gupao.pattern.factory.ICourse;
import com.fan.gupao.pattern.factory.JavaCourse;

/**
 * @Description: 抽象工厂设计模式（子类）
 * @Author: 樊高风
 * @Date: 15:28 2020/2/11
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
