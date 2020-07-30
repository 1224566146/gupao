package com.fan.gupao.demo.course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class CourseAggregateImpl implements ICourseAggregate {


    private List courseList;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList();
    }

    @Override
    public void add(Course course) {
        courseList.add(course);
    }

    @Override
    public void remove(Course course) {
        courseList.remove(course);
    }

    @Override
    public Iterator<Course> iterator() {
        return new IteratorImpl<Course>(courseList);
    }
}
