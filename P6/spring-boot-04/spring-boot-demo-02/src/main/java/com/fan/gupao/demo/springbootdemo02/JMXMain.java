package com.fan.gupao.demo.springbootdemo02;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
public class JMXMain {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {


        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.fan.gupao.demo.springbootdemo02:type=SystemInfo");
        SystemInfo systemInfo = new SystemInfo();
        mBeanServer.registerMBean(systemInfo, objectName);
        System.in.read();


    }
}
