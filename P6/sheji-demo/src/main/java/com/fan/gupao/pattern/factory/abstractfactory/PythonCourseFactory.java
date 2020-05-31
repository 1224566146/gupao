package com.fan.gupao.pattern.factory.abstractfactory;

import com.fan.gupao.pattern.factory.ICourse;
import com.fan.gupao.pattern.factory.PythonCourse;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:31 2020/2/11
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public ICourse createCourse() {
        return new PythonCourse();
    }

    @Override
    public INote createNote() {
        return null;
    }

    @Override
    public IVideo createVideo() {
        return null;
    }
}
