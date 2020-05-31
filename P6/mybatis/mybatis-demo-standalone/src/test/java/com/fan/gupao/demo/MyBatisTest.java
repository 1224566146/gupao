package com.fan.gupao.demo;

import com.fan.gupao.demo.dao.FeeMapper;
import com.fan.gupao.demo.domain.Blog;
import com.fan.gupao.demo.domain.associate.AuthorAndBlog;
import com.fan.gupao.demo.domain.associate.BlogAndAuthor;
import com.fan.gupao.demo.domain.associate.BlogAndComment;
import com.fan.gupao.demo.entity.Fee;
import com.fan.gupao.demo.mapper.BlogMapper;
import com.fan.gupao.demo.mapper.BlogMapperExt;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
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
 * @Date: 8:43 2020/5/9
 */
public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 功能描述：使用MyBatis API方式
     * @authorer: 樊高风
     * @date: 2020/5/9 9:21
     * @param:
     * @return:
     */
    @Test
    public void testStatement() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = session.selectOne("com.fan.gupao.demo.mapper.BlogMapper.selectBlogById",1000);
            System.out.println(blog);
        }finally {
            session.close();
        }
    }

    /**
     * 功能描述： 通过 SqlSession.getMapper(XXXMapper.class)  接口方式
     * @authorer: 樊高风
     * @date: 2020/5/9 9:23
     * @param:
     * @return:
     */
    @Test
    public void testSelect() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlogById(70000);
            System.out.println(blog);
        }finally {
            session.close();
        }
    }

    @Test
    public void testSelectFee() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            FeeMapper mapper = session.getMapper(FeeMapper.class);
            Fee fe = new Fee();
            fe.setFeeDate("202005");
            List<Fee> fee = mapper.selectByFeeDate(fe);
            System.out.println(fee.toString());
        }finally {
            session.close();
        }
    }

    @Test
    public void testSelectList() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

            Blog blog = new Blog();
            blog.setName("改行");
            List<Blog> list1 = new ArrayList<>();
            List<Blog> list2 = new ArrayList<>();

            list1 = mapper.selectBlogListIf(blog);
            list2 = mapper.selectBlogListChoose(blog);

            System.out.println(list1);
            System.out.println(list2);
        }finally {
            session.close();
        }
    }

    /**
     * 功能描述：动态SQL批量插入
     * @authorer: 樊高风 
     * @date: 2020/5/9 9:27
     * @param:  
     * @return:  
     */
    @Test
    public void testInsert() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

            List<Integer> list = new ArrayList();
            list.add(1);
            list.add(3);
            list.add(4);
            Blog blog = new Blog();
            blog.setBid(70000);
            blog.setName("测试插入");
            blog.setAuthorId(111111111);
            blog.setNameTest(list);
            System.out.println(mapper.insertBlog(blog));
            session.commit();
        }finally {
            session.close();
        }
    }

    /**
     * 功能描述：动态SQL批量删除
     * @authorer: 樊高风
     * @date: 2020/5/9 9:29
     * @param:
     * @return:
     */
    @Test
    public void testDelete() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

           List<Blog> list = new ArrayList<>();
           Blog blog1 = new Blog();
           blog1.setBid(666);
           list.add(blog1);
            Blog blog2 = new Blog();
            blog2.setBid(777);
            list.add(blog2);

            mapper.deleteByList(list);
        }finally {
            session.close();
        }
    }

    /**
     * 功能描述：单条更新
     * @authorer: 樊高风
     * @date: 2020/5/9 9:30
     * @param:
     * @return:
     */
    @Test
    public void testUpdate() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

            Blog blog1 = new Blog();
            blog1.setBid(333);
            blog1.setName("修改以后的名字");

            mapper.updateByPrimaryKey(blog1);
            session.commit();

        }finally {
            session.close();
        }
    }

    /**
     * 动态SQL批量更新
     * @throws IOException
     */
    @Test
    public void testUpdateBlogList() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<Blog> list = new ArrayList<Blog>();
            Blog blog1 = new Blog();
            blog1.setBid(666);
            blog1.setName("newName666");
            blog1.setAuthorId(666666);
            list.add(blog1);
            Blog blog2 = new Blog();
            blog2.setBid(777);
            blog2.setName("newName777");
            blog2.setAuthorId(777777);
            list.add(blog2);
            mapper.updateBlogList(list);
            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * 功能描述：#和$的区别
     * @authorer: 樊高风
     * @date: 2020/5/9 9:33
     * @param:
     * @return:
     */
    @Test
    public void testSelectByBean() throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

            Blog queryBean = new Blog();
            queryBean.setName("MySQL从入门到改行");

            List<Blog> blogs = mapper.selectBlogByBean(queryBean);
            System.out.println("查询结果:"+blogs);

        } finally {
            session.close();
        }
    }

    /**
     * 功能描述： 逻辑分页
     * @authorer: 樊高风
     * @date: 2020/5/9 9:36
     * @param:
     * @return:
     */
    @Test
    public void testSelectByRowBounds() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

            int start = 0;
            int pageSize = 5;
            RowBounds rb = new RowBounds(start,pageSize);
            List<Blog> list = mapper.selectBlogList(rb);// 使用逻辑分页

            for (Blog blog : list) {
                System.out.println(blog);
            }

        } finally {
            session.close();
        }
    }

    /**
     * 功能描述：Mapper.xml的继承性
     * @authorer: 樊高风
     * @date: 2020/5/9 9:38
     * @param:
     * @return:
     */
    @Test
    public void testMapperExt() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapperExt mapper = session.getMapper(BlogMapperExt.class);
            Blog blog = mapper.selectBlogByName("MySQL从入门到改行");
            System.out.println(blog);

            //继承了父Mapper的方法
            Blog blog1 = mapper.selectBlogById(1);
            System.out.println(blog1);
        } finally {
            session.close();
        }
    }

    /**
     * 功能描述：一对一，一篇文章对应一个作者
     * 嵌套结果，不存在N+1问题
     * @authorer: 樊高风
     * @date: 2020/5/9 9:39
     * @param:
     * @return:
     */
    @Test
    public void testSelectBlogWithAuthorResult() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        BlogAndAuthor blogAndAuthor = mapper.selectBlogWithAuthorResult(1);
        System.out.println("--------------"+blogAndAuthor);
    }

    /**
     * 功能描述：一对一，一篇文章对应一个作者
     * 嵌套查询，会有N+1的问题
     * @authorer: 樊高风
     * @date: 2020/5/9 9:42
     * @param:
     * @return:
     */
    @Test
    public void testSelectBlogWithAuthorQuery() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        BlogAndAuthor blog = mapper.selectBlogWithAuthorQuery(1);
        System.out.println("--------------"+blog.getClass());

        //如果开启了延迟加载(lazyLoadingEnabled=true)，会在使用的时候才发出SQL
        // equals,clone,hashCode,toString也会触发延迟加载
//        System.out.println("----------------调用toString方法："+blog);
//        System.out.println("----------------getAuthor:"+blog.getAuthor().toString());
        // 如果 aggressiveLazyLoading = true ，也会触发加载，否则不会
        //System.out.println("-----------getName:"+blog.getName());
    }

    /**
     * 功能描述：一对多关联查询：一篇文章对应多条评论
     * @authorer: 樊高风
     * @date: 2020/5/9 9:45
     * @param:
     * @return:
     */
    @Test
    public void testSelectBlogWithComment() throws IOException{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            BlogAndComment blogAndComment = mapper.selectBlogWithCommentById(1);
            System.out.println(blogAndComment);
        }finally {
            session.close();
        }
    }

    /**
     * 功能描述：多对多关联查询：作者的文章的评论
     * @authorer: 樊高风
     * @date: 2020/5/9 9:47
     * @param:
     * @return:
     */
    @Test
    public void testSelectAuthorWithBlog() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);

            List<AuthorAndBlog> authorAndBlogs = mapper.selectAuthorWithBlog();

            for (AuthorAndBlog authorAndBlog : authorAndBlogs) {
                System.out.println(authorAndBlog);
            }
        }finally {
            session.close();
        }
    }
}
