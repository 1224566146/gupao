package com.fan.gupao.pattern.factory.factorymethod;

import com.fan.gupao.pattern.factory.ICourse;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:59 2020/2/11
 */
public class FactoryMehtodTest {
    public static void main(String[] args) {

        ICourseFactory factory = new JavaCourseFactory();
        ICourse iCourse = factory.create();
        iCourse.record();

    }
}
