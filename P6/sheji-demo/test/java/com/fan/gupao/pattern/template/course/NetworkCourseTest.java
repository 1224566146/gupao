package com.fan.gupao.pattern.template.course;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:35 2020/3/6
 */
public class NetworkCourseTest {


    public static void main(String[] args) {


        System.out.println("Java架构师课程");
        NetworkCourse networkCourse = new JavaCourse();
        networkCourse.createCourse();

        System.out.println("大数据课程");
        NetworkCourse networkCourse1 = new BigDataCourse(true);
        networkCourse1.createCourse();

    }
}
