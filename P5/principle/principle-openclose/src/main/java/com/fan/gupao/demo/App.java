package com.fan.gupao.demo;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1, "Java架构", 11800D);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) iCourse;

        System.out.println("课程ID:" + javaDiscountCourse.getId() +
                "\n课程标题:<<" + javaDiscountCourse.getName() + ">>" +
                "\n原价:" + javaDiscountCourse.getPrice() +
                "\n售价:" + javaDiscountCourse.getDiscountPrice());
    }
}
