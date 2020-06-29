package com.fan.gupao.demo.springbootdemo02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
@Component
public class GpApplicationMXBeanRegistrar implements ApplicationContextAware, EnvironmentAware, InitializingBean, DisposableBean {

    private ConfigurableApplicationContext applicationContext;

    private Environment environment = new StandardEnvironment();

    private final ObjectName objectName =new ObjectName("com.fan.gupao.demo.springbootdemo02:type=SystemInfo");

    public GpApplicationMXBeanRegistrar() throws MalformedObjectNameException {
    }


    @Override
    public void destroy() throws Exception {
        ManagementFactory.getPlatformMBeanServer().unregisterMBean(this.objectName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(new SystemInfo(),this.objectName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
