package com.fan.gupao.demo.course;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public interface ICourseAggregate {

    void add(Course course);

    void remove(Course course);

    Iterator<Course> iterator();

}
