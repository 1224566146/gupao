package com.fan.gupao.demo;

import com.fan.gupao.demo.domain.Blog;
import com.fan.gupao.demo.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:04 2020/5/8
 */
public class BatchOperateTest {
    private BlogMapper mapper;
    private SqlSession session;

    @Before
    public void init(){
        System.out.println("init......");
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            mapper = session.getMapper(BlogMapper.class);
        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }
    }

    /**
     * 功能描述：循环批量插入
     * @authorer: 樊高风
     * @date: 2020/5/8 20:09
     * @param:
     * @return:
     */
    @Test
    public void testInsertOneByOne(){
        long start = System.currentTimeMillis();
        int count = 10100;
        for (int i = 100; i < count; i++) {
            Blog blog = new Blog();
            blog.setBid(i);
            blog.setName("name"+i);
            blog.setAuthorId(i);
            mapper.insertBlog(blog);
        }
        session.commit();
        session.close();
        long end = System.currentTimeMillis();
        System.out.println("循环批量插入"+count+"条，耗时："+(end-start)+"毫秒");
    }

    /**
     * 功能描述：动态SQL批量插入
     * @authorer: 樊高风
     * @date: 2020/5/8 20:32
     * @param:
     * @return:
     */
    @Test
    public void testInsert() throws IOException{
        long start = System.currentTimeMillis();
        int count = 40000;
        List<Blog> list = new ArrayList<>();
        for (int i = 30000; i < count; i++) {
            Blog blog = new Blog();
            blog.setBid(i);
            blog.setName("name" + i);
            blog.setAuthorId(i);
            list.add(blog);
        }
        mapper.insertBlogList(list);
        session.commit();
        session.close();
        long end = System.currentTimeMillis();
        System.out.println("动态SQL批量插入"+count+"条，耗时"+(end-start)+"毫秒");
    }

    /**
     * 功能描述：动态SQL批量更新
     * @authorer: 樊高风
     * @date: 2020/5/8 20:32
     * @param:
     * @return:
     */
    @Test
    public void updateBlogList() throws IOException{
        long start = System.currentTimeMillis();
        int count = 10100;
        List<Blog> list = new ArrayList<>();
        for (int i = 100; i < count; i++) {
            Blog blog = new Blog();
            blog.setBid(i);
            blog.setName("modified name" + i);
            blog.setAuthorId(i);
            list.add(blog);
        }
        mapper.updateBlogList(list);
        session.commit();
        session.close();
        long end = System.currentTimeMillis();
        System.out.println("动态SQL批量插入"+count+"条，耗时"+(end-start)+"毫秒");


    }
}
