package com.fan.gupao.demo.interfaced;

/**
 * @author 樊高风
 * @date 2020/6/19 18:50
 */
public class CourseImpl implements ICourseInfo,ICourseManager {
    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
