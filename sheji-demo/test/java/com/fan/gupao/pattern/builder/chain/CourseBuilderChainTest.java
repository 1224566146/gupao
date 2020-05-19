package com.fan.gupao.pattern.builder.chain;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:16 2020/5/19
 */
public class CourseBuilderChainTest {

    public static void main(String[] args) {

        CourseBuilder courseBuilder = new CourseBuilder();
        courseBuilder.addName("架构师").addNote("设计模式");

        CourseBuilder.Course builde = courseBuilder.builde();

        System.out.println(builde);


    }
}
