package com.fan.gupao.demo.zookeeperleader;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/9/13
 */
@Configuration
public class QuartzConfig {


    @Bean
    public ZkSchedulerFactoryBean schedulerFactoryBean() throws Exception {
        ZkSchedulerFactoryBean schedulerFactoryBean = new ZkSchedulerFactoryBean();
        schedulerFactoryBean.setJobDetails(jobDetail());
        schedulerFactoryBean.setTriggers(trigger());
        return schedulerFactoryBean;
    }


    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(QuartzJob.class).storeDurably().build();
    }


    @Bean
    public Trigger trigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1).repeatForever();
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withSchedule(simpleScheduleBuilder).build();
    }

}
