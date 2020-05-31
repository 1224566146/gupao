package com.fan.gupao.demo.domain.associate;

import com.fan.gupao.demo.domain.Author;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:16 2020/5/8
 */
public class BlogAndAuthor implements Serializable {


    private static final long serialVersionUID = 6913357987677088539L;
    private Integer bid;

    private String name;

    private Author author;

    @Override
    public String toString() {
        return "BlogAndAuthor{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", author=" + author +
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
