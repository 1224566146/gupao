package com.fan.gupao.demo.simple;

/**
 * @author 樊高风
 * @date 2020/6/19 18:45
 */
public class Course {

    public void study(String courseName){
        if("直播课".equals(courseName)){
            System.out.println("不能快进");
        }else{
            System.out.println("可以任意的来回播放");
        }
    }

}
