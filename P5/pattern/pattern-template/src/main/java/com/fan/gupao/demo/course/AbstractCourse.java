package com.fan.gupao.demo.course;

/**
 * @author 樊高风
 * @date 2020/7/7
 */
public abstract class AbstractCourse {

    public final void createCourse(){

        // 1、发布预习资料
        postPreResourse();

        // 2、制作课件
        createPPT();

        // 3、直播授课
        liveVideo();

        // 4、上传课后资料
        postResource();

        // 5、布置作业
        postHomework();

        if(needCheckHomework()){
            checkHomework();
        }
    }

    // 钩子方法
    protected  boolean needCheckHomework(){
        return false;
    }

    protected abstract void checkHomework();

    protected  void postHomework(){
        System.out.println("布置作业");
    }

    protected  void postResource(){
        System.out.println("上传课后资料");
    }

    protected  void liveVideo(){
        System.out.println("直播授课");
    }

    protected  void createPPT(){
        System.out.println("制作课件");
    }

    protected  void postPreResourse(){
        System.out.println("发布预习资料");
    }

}
