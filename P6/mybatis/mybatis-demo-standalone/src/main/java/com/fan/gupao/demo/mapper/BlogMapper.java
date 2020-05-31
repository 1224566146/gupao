package com.fan.gupao.demo.mapper;

import com.fan.gupao.demo.domain.Blog;
import com.fan.gupao.demo.domain.BlogExample;
import com.fan.gupao.demo.domain.associate.AuthorAndBlog;
import com.fan.gupao.demo.domain.associate.BlogAndAuthor;
import com.fan.gupao.demo.domain.associate.BlogAndComment;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:21 2020/5/8
 */
public interface BlogMapper {

    /**
     * 功能描述：根据主键查询文章
     * @authorer: 樊高风
     * @date: 2020/5/8 15:22
     * @param:
     * @return:
     */
    Blog selectBlogById(Integer bid);

    List<Blog> selectBlogByBean(Blog blog);

    List<Blog> selectBlogList(RowBounds rowBounds);

    List<Blog> selectBlogListIf(Blog blog);

    List<Blog> selectBlogListChoose(Blog blog);

    void deleteByList(List<Blog> list);

    int updateByPrimaryKey(Blog blog);

    int insertBlog(Blog blog);

    int insertBlogList(List<Blog> list);

    int updateBlogList(List<Blog> list);

    /**
     * 根据博客查询作者，一对一，嵌套结果
     * @param bid
     * @return
     */
    BlogAndAuthor selectBlogWithAuthorResult(Integer bid);

    /**
     * 根据博客查询作者，一对一，嵌套查询，存在N+1问题
     * @param bid
     * @return
     */
    BlogAndAuthor selectBlogWithAuthorQuery(Integer bid);

    /**
     * 查询文章带出文章所有评论（一对多）
     * @param bid
     * @return
     */
    BlogAndComment selectBlogWithCommentById(Integer bid);

    /**
     * 查询作者带出博客和评论（多对多）
     * @return
     */
    List<AuthorAndBlog> selectAuthorWithBlog();

    List<Blog> selectByExample(BlogExample example);
}
