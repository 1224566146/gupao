package com.fan.gupao.demo.domain.associate;


import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:14 2020/5/8
 */
public class AuthorAndBlog implements Serializable {


    private static final long serialVersionUID = 913714889047725960L;
    // 作者ID
    private Integer author_id;

    // 作者名称
    private String author_name;

    // 文章和评论列表
    private List<BlogAndComment> blog;

    @Override
    public String toString() {
        return "AuthorAndBlog{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", blog=" + blog +
                '}';
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public List<BlogAndComment> getBlog() {
        return blog;
    }

    public void setBlog(List<BlogAndComment> blog) {
        this.blog = blog;
    }
}
