package com.fan.gupao.pattern.factory.abstractfactory;

import com.fan.gupao.pattern.factory.ICourse;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:33 2020/2/11
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        ICourse course = courseFactory.createCourse();
        course.record();
        INote note = courseFactory.createNote();
        note.edit();
    }
}
