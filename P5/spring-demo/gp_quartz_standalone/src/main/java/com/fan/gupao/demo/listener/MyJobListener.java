package com.fan.gupao.demo.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class MyJobListener implements JobListener {

    /**
     * 功能描述: 获取Job名称
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/20 16:50
     */
    @Override
    public String getName() {
        String name = getClass().getSimpleName();
        System.out.println("获取到的监听器的名称是:"+name);
        return name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println(name+"即将执行");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println(name+"任务被取消掉了");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println(name +"任务执行完成了");
    }
}
