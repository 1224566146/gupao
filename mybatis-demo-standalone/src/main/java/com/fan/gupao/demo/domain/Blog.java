package com.fan.gupao.demo.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:56 2020/5/8
 */
public class Blog implements Serializable {

    private static final long serialVersionUID = -5644060606150325324L;

    // 文章ID
    private Integer bid;

    // 文章标题
    private String name;

    // 文章作者ID
    private Integer authorId;

    private List<Integer> nameTest;

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

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                '}';
    }

    public List<Integer> getNameTest() {
        return nameTest;
    }

    public void setNameTest(List<Integer> nameTest) {
        this.nameTest = nameTest;
    }
}
