package com.fan.gupao.pattern.builder.chain;

import lombok.Data;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:13 2020/5/19
 */
public class CourseBuilder {

    private Course course = new Course();

    public CourseBuilder addName(String name){
        course.setName(name);
        return this;
    }

    public CourseBuilder addPpt(String ppt){
        course.setPpt(ppt);
        return this;
    }

    public CourseBuilder addVideo(String video){
        course.setVideo(video);
        return this;
    }

    public CourseBuilder addNote(String note){
        course.setNote(note);
        return this;
    }

    public CourseBuilder addHomeWork(String homeWork){
        course.setHomeWork(homeWork);
        return this;
    }

    public Course builde(){
        return course;
    }


    @Data
    class Course{

        private String name;
        private String ppt;
        private String video;
        private String note;
        private String homeWork;

        @Override
        public String toString() {
            return "Course{" +
                    "name='" + name + '\'' +
                    ", ppt='" + ppt + '\'' +
                    ", video='" + video + '\'' +
                    ", note='" + note + '\'' +
                    ", homeWork='" + homeWork + '\'' +
                    '}';
        }

    }
}
