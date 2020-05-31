package com.fan.gupao.pattern.factory.simplefactory;

import com.fan.gupao.pattern.factory.ICourse;

/**
 * @Description: 简单工厂设计模式
 * @Author: 樊高风
 * @Date: 17:16 2020/2/9
 */
public class CourseFactory {

//    public ICourse create(String name){
//        if("java".equals(name)){
//            return new JavaCourse();
//        }else if("python".equals(name)){
//            return new PythonCourse();
//        }else{
//            return null;
//        }
//    }

//    public ICourse create(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        if(!"".equals(name) || null != name){
//            return  (ICourse) Class.forName(name).newInstance();
//        }
//        return null;
//    }

    public ICourse create(Class<? extends ICourse> clazz) throws IllegalAccessException, InstantiationException {
        if(null != clazz){
            return clazz.newInstance();
        }
        return null;
    }

}
