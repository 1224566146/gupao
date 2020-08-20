package com.fan.gupao.demo.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class MyTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        return "TriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("...... was fired");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("... was not vetoed");
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("... was not fired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        System.out.println("... was Complete");
    }
}
