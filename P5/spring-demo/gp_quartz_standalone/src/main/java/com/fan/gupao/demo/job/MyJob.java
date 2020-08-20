package com.fan.gupao.demo.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class MyJob implements Job {

    /**
     * 功能描述: 任务触发要执行的方法
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/20 16:42
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取任务执行时动态绑定的数据
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println(jobDataMap.getString("gupao")+"我是谁?我在哪?"+jobDataMap.getString("name"));
    }
}
