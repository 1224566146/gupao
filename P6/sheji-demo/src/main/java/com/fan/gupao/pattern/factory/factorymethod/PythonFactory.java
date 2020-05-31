package com.fan.gupao.pattern.factory.factorymethod;

import com.fan.gupao.pattern.factory.ICourse;
import com.fan.gupao.pattern.factory.PythonCourse;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:58 2020/2/11
 */
public class PythonFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
