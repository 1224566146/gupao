package com.fan.gupao.pattern.template.course;

/**
 * @Description: 模版会有一个或者多个未实现方法
 *                而且这几个为实现方法有固定的执行顺序
 * @Author: 樊高风
 * @Date: 19:23 2020/3/6
 */
public abstract class NetworkCourse {

    protected final void createCourse(){

        //1、发布预习资料
        this.postPreResource();

        //2、制作PPT课件
        this.createPPT();

        //3、在线直播
        this.liveVideo();

        //4、提交课件、课堂笔记
        this.postNote();

        //5、提交源码
        this.postSource();

        //6、布置作业，有些课是没有作业，有些课是有作业的
        //如果有作业的话，检查作业。如果没作业，完成了
        if(needHomework()){
            checkHomework();
        }



    }


    abstract void checkHomework();

    //钩子方法：实现流程的微调
    protected boolean needHomework(){
        return false;
    }

    final void postSource(){
        System.out.println("提交源代码");
    }

    final void postNote(){
        System.out.println("提交课件和笔记");
    }

    final void liveVideo(){
        System.out.println("直播授课");
    }

    final void createPPT(){
        System.out.println("创建备课PPT");
    }

    final void postPreResource(){
        System.out.println("发布预习资料");
    }

}
