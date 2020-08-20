package com.fan.gupao.demo.test;

import com.fan.gupao.demo.job.MyJob;
import com.fan.gupao.demo.listener.MySchedulerListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class Test {


    public static void main(String[] args) throws Exception {


        // 创建一个对应的触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever())
                .build();

        // JobDetial
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("gupao", "咕泡666")
                .usingJobData("name", "波波老师")
                .build();

        // 将JobDetail和Trigger关联起来
        SchedulerFactory factory = new StdSchedulerFactory();
        // 通过工厂对象获取对应的Schedule对象
        Scheduler scheduler = factory.getScheduler();
        // 绑定JobDetail和Trigger
        scheduler.scheduleJob(jobDetail,trigger);

        // 创建并注册一个全局的Job Listener
//        scheduler.getListenerManager()
//                .addJobListener(new MyJobListener(), EverythingMatcher.allJobs());
        // 创建并注册一个监听特定Job的Listener
//        scheduler.getListenerManager()
//                .addJobListener(new MyJobListener(),
//                        KeyMatcher.keyEquals(JobKey.jobKey("job2","group1")));
//        scheduler.getListenerManager()
//                .addTriggerListener(new MyTriggerListener(), EverythingMatcher.allTriggers());
        scheduler.getListenerManager()
                .addSchedulerListener(new MySchedulerListener());
        scheduler.start();


    }

}
