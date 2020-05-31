package com.fan.gupao.demo;

import com.fan.gupao.demo.domain.Blog;
import com.fan.gupao.demo.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:51 2020/5/8
 */
public class PageInterceptorTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    public void testPlugin(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int start = 5; //offset
            int pageSize = 5; // limit
            RowBounds rb = new RowBounds(start, pageSize);
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<Blog> list = mapper.selectBlogList(rb);
        }finally {
            session.close();
        }
    }
}
