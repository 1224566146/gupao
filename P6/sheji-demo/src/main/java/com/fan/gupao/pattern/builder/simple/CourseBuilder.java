package com.fan.gupao.pattern.builder.simple;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:08 2020/5/19
 */
public class CourseBuilder {

    private Course course = new Course();

    public void addName(String name){
        course.setName(name);
    }

    public void addPpt(String ppt){
        course.setPpt(ppt);
    }

    public void addVideo(String video){
        course.setVideo(video);
    }

    public void addNote(String note){
        course.setNote(note);
    }

    public void addHomeWork(String homeWork){
        course.setHomeWork(homeWork);
    }

    public Course builde(){
        return course;
    }

}
