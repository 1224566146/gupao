package com.fan.gupao.pattern.builder.simple;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:11 2020/5/19
 */
public class CourseBuilderTest {

    public static void main(String[] args) {

        CourseBuilder courseBuilder = new CourseBuilder();
        courseBuilder.addName("架构师");
        courseBuilder.addNote("设计模式");

        Course course = courseBuilder.builde();

        System.out.println(course);

    }
}
