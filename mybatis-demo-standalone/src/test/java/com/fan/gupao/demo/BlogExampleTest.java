package com.fan.gupao.demo;

import com.fan.gupao.demo.domain.Blog;
import com.fan.gupao.demo.domain.BlogExample;
import com.fan.gupao.demo.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:34 2020/5/8
 */
public class BlogExampleTest {

    @Test
    public void testExample() throws IOException{

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {

            BlogMapper mapper = session.getMapper(BlogMapper.class);
            BlogExample example = new BlogExample();
            BlogExample.Criteria criteria = example.createCriteria();
            criteria.andBidEqualTo(1000);
            List<Blog> list = mapper.selectByExample(example);
            System.out.println(list);

        }finally {
            session.close();
        }

    }


}
