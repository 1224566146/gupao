package com.fan.gupao.demo.springbootdemo02;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
public interface SystemInfoMBean {

    int getCpuCore();

    long getTotalMemory();

    void shutdown();
}
