package com.fan.gupao.pattern.template.course;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:32 2020/3/6
 */
public class BigDataCourse extends NetworkCourse {

    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag){
        this.needHomeworkFlag = needHomeworkFlag;
    }


    @Override
    void checkHomework() {
        System.out.println("检查大数据的课后作业");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
