package com.fan.gupao.spring.framework.beans.support;

import com.fan.gupao.spring.framework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 18:41 2020/4/3
 */
public class GPBeanDefinitionReader {

    private Properties properties = new Properties();

    //保存扫描的结果
    private List<String> regitryBeanClasses = new ArrayList<>();

    //固定配置文件中的key,相对于xml的规范
    private final String SCAN_PACKAGE = "scanPackage";


    public GPBeanDefinitionReader(String... configLocations) {
        doLoadConfig(configLocations[0]);

        //扫描配置文件中的配置的相关的类
        doScanner(properties.getProperty(SCAN_PACKAGE));
    }

    /**
     * 功能描述：扫描相关的类
     *
     * @authorer: 樊高风
     * @date: 2020/4/3 18:51
     * @param:
     * @return:
     */
    private void doScanner(String scanPackage) {
        //jar、war、zip、rar
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());

        //当成是一个ClassPath文件夹
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if(!file.getName().endsWith(".class")){
                    continue;
                }
                //全类名 = 包名.类名
                String className = (scanPackage + "." +file.getName().replace(".class",""));
                //Class.forName(className)
                regitryBeanClasses.add(className);

            }
        }


    }

    /**
     * 功能描述：加载配置文件
     *
     * @authorer: 樊高风
     * @date: 2020/4/3 18:45
     * @param:
     * @return:
     */
    private void doLoadConfig(String configLocation) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configLocation.replaceAll("classpath:", ""));
        try {
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * 功能描述：解析配置文件，封装成BeanDefinition
     * @authorer: 樊高风
     * @date: 2020/4/3 19:02
     * @param:
     * @return:
     */
    public List<GPBeanDefinition> loadBeanDefinitions() {
        List<GPBeanDefinition> result = new ArrayList<>();
        try {
            for (String className : regitryBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                //如果是一个接口，是不能实例化的
                //用它实现类来实例化
                boolean isCheck = beanClass.isInterface();
                if(isCheck){
                    continue;
                }
                //保存类对应的ClassName（全类名）
                //还有beanName
                //1、默认是类名首字母小写
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()),beanClass.getName()));

                //2、自定义

                //3、接口注入
                for (Class<?> i : beanClass.getInterfaces()) {
                    //如果是多个实现类，只能覆盖
                    //为什么？因为Spring没那么智能，就是这么傻
                    //这个时候，可以自定义名字
                    result.add(doCreateBeanDefinition(i.getName(), beanClass.getName()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 功能描述：创建Bean
     * @authorer: 樊高风
     * @date: 2020/4/3 19:10
     * @param:
     * @return:
     */
    private GPBeanDefinition doCreateBeanDefinition(String beanName,String beanClassName){
        GPBeanDefinition beanDefinition = new GPBeanDefinition();
        beanDefinition.setFactoryBeanName(beanName);
        beanDefinition.setBeanClassName(beanClassName);
        return beanDefinition;
    }

    /**
     * 功能描述:将首字母转换为小写
     * 如果类名本身就是小写字母，确实会出问题
     * 但是我要说明的是：这个方法是我自己用的，private的
     * 传值也是自己传，类也都遵循了驼峰命名法
     * 默认传入的值，存在首字母小写的情况，也不可能出现非字母的情况
     *
     * 为了简化程序逻辑，就不做其他判断了，大家了解就OK
     *
     * @authorer: 樊高风
     * @date: 2020/4/3 19:09
     * @param:
     * @return:
     */
    private String toLowerFirstCase(String simpleName){
        char[] chars = simpleName.toCharArray();
        //之所以加，是因为大小写字母的ASCII码相差32
        //而且大写字母的ASCII码要小于小写字母的ASCII码
        //在Java中，对char做算学运算，实际上就是对ASCII码做算学运算
        chars[0] +=32;
        return String.valueOf(chars);
    }
}
