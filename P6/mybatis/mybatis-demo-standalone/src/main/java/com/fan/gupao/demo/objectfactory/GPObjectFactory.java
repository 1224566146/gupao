package com.fan.gupao.demo.objectfactory;

import com.fan.gupao.demo.domain.Blog;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * @Description: <p>
 * 自定义ObjectFactory，通过反射的方式实例化对象
 * 一种是无参构造函数，一种是有参构造函数——第一个方法调用了第二个方法
 * @Author: 樊高风
 * @Date: 17:33 2020/5/8
 */
public class GPObjectFactory extends DefaultObjectFactory {
    @Override
    public Object create(Class type) {
        System.out.println("创建对象方法: "+type);
        if(type.equals(Blog.class)){
            Blog blog = (Blog) super.create(type);
            blog.setName("object factory");
            blog.setBid(11111);
            blog.setAuthorId(22222);
            return blog;
        }
        return super.create(type);
    }
}
