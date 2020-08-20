package com.fan.gupao.demo.listener;

import org.quartz.*;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class MySchedulerListener implements SchedulerListener {
    @Override
    public void jobScheduled(Trigger trigger) {
        String jobName = trigger.getJobKey().getName();
        System.out.println(jobName + " has been scheduled");
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        System.out.println(triggerKey + " is being unscheduled");
    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        System.out.println("Trigger is finished for " + trigger.getJobKey().getName());
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {
        System.out.println(triggerKey + " is being paused");
    }

    @Override
    public void triggersPaused(String triggerGroup) {
        System.out.println("trigger group " + triggerGroup + " is being paused");
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {
        System.out.println(triggerKey + " is being resumed");
    }

    @Override
    public void triggersResumed(String triggerGroup) {
        System.out.println("trigger group " + triggerGroup + " is being resumed");
    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        System.out.println(jobDetail.getKey() + " is added");
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        System.out.println(jobKey + " is deleted");
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        System.out.println(jobKey + " is paused");
    }

    @Override
    public void jobsPaused(String jobGroup) {
        System.out.println("job group " + jobGroup + " is paused");
    }

    @Override
    public void jobResumed(JobKey jobKey) {
        System.out.println(jobKey + " is resumed");
    }

    @Override
    public void jobsResumed(String jobGroup) {
        System.out.println("job group " + jobGroup + " is resumed");
    }

    @Override
    public void schedulerError(String msg, SchedulerException cause) {
        System.out.println(msg + cause.getUnderlyingException().getStackTrace());
    }

    @Override
    public void schedulerInStandbyMode() {
        System.out.println("scheduler is in standby mode");
    }

    @Override
    public void schedulerStarted() {
        System.out.println("scheduler has been started");
    }

    @Override
    public void schedulerStarting() {
        System.out.println("scheduler is being started");
    }

    @Override
    public void schedulerShutdown() {
        System.out.println("scheduler has been shutdown");
    }

    @Override
    public void schedulerShuttingdown() {
        System.out.println("scheduler is being shutdown");
    }

    @Override
    public void schedulingDataCleared() {
        System.out.println("scheduler has cleared all data");
    }
}
