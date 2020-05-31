package com.fan.gupao.pattern.factory.simplefactory;

import com.fan.gupao.pattern.factory.ICourse;
import com.fan.gupao.pattern.factory.JavaCourse;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:15 2020/2/9
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        CourseFactory courseFactory = new CourseFactory();
        ICourse iCourse = null;
        try {
            iCourse = courseFactory.create(JavaCourse.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        iCourse.record();
    }
}
