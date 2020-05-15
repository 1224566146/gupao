package com.fan.gupao.mybatis.v1;

import com.fan.gupao.mybatis.v1.mapper.Blog;
import com.fan.gupao.mybatis.v1.mapper.BlogMapper;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:21 2020/5/14
 */
public class MyBatisBoot {
    public static void main(String[] args) {

        GPSqlSession gpSqlSession = new GPSqlSession(new GPConfiguration(), new GPExecutor());
        BlogMapper blogMapper = gpSqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectBlogById(70000);
        System.out.println(blog);
    }
}
