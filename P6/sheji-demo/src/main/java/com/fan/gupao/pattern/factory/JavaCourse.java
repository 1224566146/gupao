package com.fan.gupao.pattern.factory;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:14 2020/2/9
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
