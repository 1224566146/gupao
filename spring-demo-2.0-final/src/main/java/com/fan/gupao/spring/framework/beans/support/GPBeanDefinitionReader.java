package com.fan.gupao.spring.framework.beans.support;

import com.fan.gupao.spring.framework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:54 2020/4/27
 */
public class GPBeanDefinitionReader {

    //保存扫描的结果
    private List<String> regitryBeanClasses = new ArrayList<>();

    private Properties contextConfig = new Properties();

    public GPBeanDefinitionReader(String... configLocations) {

        doLoadConfig(configLocations[0]);

        //扫描配置文件中的配置的相关的类
        doScanner(contextConfig.getProperty("scanPackage"));

    }


    public List<GPBeanDefinition> loadBeanDefinitions() {
        List<GPBeanDefinition> result = new ArrayList<>();
        try {
            for (String className : regitryBeanClasses) {

                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) {
                    continue;
                }
                //保存类对应的ClassName(全类名)
                //还有BeanName
                //1、默认是首字母小写
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()), beanClass.getName()));
                //2、自定义
                //3、接口注入
                for (Class<?> i : beanClass.getInterfaces()) {
                    result.add(doCreateBeanDefinition(i.getName(), beanClass.getName()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private GPBeanDefinition doCreateBeanDefinition(String beanName, String beanClassName) {
        GPBeanDefinition gpBeanDefinition = new GPBeanDefinition();
        gpBeanDefinition.setBeanClassName(beanClassName);
        gpBeanDefinition.setFactoryBeanName(beanName);
        return gpBeanDefinition;
    }


    private void doScanner(String scanPackage) {

        //jar war zip rar
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());

        //当成是一个classPath文件夹
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                //全类名 = 包名.类名
                String className = (scanPackage + "." + file.getName().replace(".class", ""));
                regitryBeanClasses.add(className);
            }
        }

    }

    private void doLoadConfig(String contextConfigLocaion) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocaion.replaceAll("classpath:", ""));
        try {
            contextConfig.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Properties getConfig(){
        return this.contextConfig;
    }

    //自己写，自己用
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
//        if(chars[0] > )
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
