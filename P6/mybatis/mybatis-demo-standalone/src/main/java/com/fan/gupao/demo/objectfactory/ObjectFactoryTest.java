package com.fan.gupao.demo.objectfactory;

import com.fan.gupao.demo.domain.Blog;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:35 2020/5/8
 */
public class ObjectFactoryTest {
    public static void main(String[] args) {
        GPObjectFactory factory = new GPObjectFactory();
        Blog blog = (Blog) factory.create(Blog.class);
        System.out.println(blog);
    }
}
