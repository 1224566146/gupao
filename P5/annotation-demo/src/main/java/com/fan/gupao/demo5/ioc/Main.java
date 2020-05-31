package com.fan.gupao.demo5.ioc;

import com.fan.gupao.demo5.anno.SevenBean;
import com.fan.gupao.demo5.anno.SevenComponent;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:19 2020/5/31
 */
public class Main {

    public static void main(String[] args) throws Exception {

        HashSet<String> allClassPathSet = new HashSet<>();

        doScanner(allClassPathSet, "com.fan.gupao.demo5.ioc");

        for (String className : allClassPathSet) {
            Class<?> clazz = Class.forName(className);

            // SevenComponent注解  处理方式  默认的构造bean实例化的过程..
            if(clazz.isAnnotationPresent(SevenComponent.class)){
                IOCContainer.putBean(className, clazz.newInstance());
            }

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {

                if(method.isAnnotationPresent(SevenBean.class)){
                    String beanName = method.getAnnotation(SevenBean.class).value();

                    // 判断静态工厂
                    if(Modifier.isStatic(method.getModifiers())){
                        IOCContainer.putBean(beanName, method.invoke(null));
                    }else{ // 实例工厂
                        // 从容器中获取当前这实例对象
                        IOCContainer.putBean(beanName, method.invoke(IOCContainer.getBean(className)));
                    }

                }

            }
        }

    }




    /**
     * 功能描述：得到指定包下所有的class全路径
     * @authorer: 樊高风
     * @date: 2020/5/31 11:24
     * @param:
     * @return:
     */
    public static void doScanner(Set<String> allClassPathSet, String scanPackage){
        URL url = Main.class.getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if(file.isDirectory()){
                // 是文件夹，递归循环
                doScanner(allClassPathSet, scanPackage+"."+file.getName());
            }else{
                // 如果文件不是.class结尾
                if(!file.getName().endsWith(".class")){
                    continue;
                }
                // 拼装类的全路径
                String className = (scanPackage+"."+file.getName().replace(".class", ""));

                // 添加到集合中
                allClassPathSet.add(className);
            }
        }

    }
}
