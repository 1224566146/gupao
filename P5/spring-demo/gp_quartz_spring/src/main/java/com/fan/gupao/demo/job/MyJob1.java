package com.fan.gupao.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class MyJob1 implements Job {

    private Logger logger = LoggerFactory.getLogger(MyJob1.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("任务1执行了...."+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
