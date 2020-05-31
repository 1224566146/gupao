package com.fan.gupao.demo.domain;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:05 2020/5/8
 */
public class Author implements Serializable {


    private static final long serialVersionUID = 4237948692203812700L;
    // 作者ID
    private Integer authorId;

    // 作者名称
    private String authorName;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
