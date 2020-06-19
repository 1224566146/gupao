package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/19 18:37
 */
public class Tom {


//    public void studyJavaCourse(){
//        System.out.println("Tom正在学习Java课程");
//    }
//
//    public void studyPythonCourse(){
//        System.out.println("Tom正在学习Python课程");
//    }
//
//    public void studyAICourse(){
//        System.out.println("Tom正在学习AI课程");
//    }
//
//    public void study(ICourse iCourse){
//        iCourse.study();
//    }

    private ICourse iCourse;

//    public Tom(ICourse iCourse) {
//        this.iCourse = iCourse;
//    }

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study(){
        iCourse.study();
    }
}
