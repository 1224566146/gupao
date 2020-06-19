package com.fan.gupao.demo.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/6/19 20:04
 */
public class Employee {

    public void checkNumberOfCourses(){
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量为:"+courseList.size());
    }
}
