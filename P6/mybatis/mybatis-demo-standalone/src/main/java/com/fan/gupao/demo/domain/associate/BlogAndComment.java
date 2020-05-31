package com.fan.gupao.demo.domain.associate;

import com.fan.gupao.demo.domain.Comment;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:17 2020/5/8
 */
public class BlogAndComment implements Serializable {


    private static final long serialVersionUID = -1102203737149625561L;
    private Integer bid;

    private String name;

    private Integer authorId;

    private List<Comment> comment;

    @Override
    public String toString() {
        return "BlogAndComment{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", comment=" + comment +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
