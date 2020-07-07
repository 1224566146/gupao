package com.fan.gupao.demo.course;

/**
 * @author 樊高风
 * @date 2020/7/7
 */
public class Test {

    public static void main(String[] args) {


        System.out.println("=============架构师课程================");
        JavaCourse java = new JavaCourse();
        java.setNeedCheckHomework(true);
        java.createCourse();


        System.out.println("==============Python========================");
        PythoneCourse python = new PythoneCourse();
        python.createCourse();
    }

}
