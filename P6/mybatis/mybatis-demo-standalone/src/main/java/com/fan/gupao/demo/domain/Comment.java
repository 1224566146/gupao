package com.fan.gupao.demo.domain;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:07 2020/5/8
 */
public class Comment implements Serializable {


    private static final long serialVersionUID = -5240887629835326008L;
    // 评论ID
    private Integer commentId;

    // 所属文章ID
    private Integer bid;

    // 内容
    private String content;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", bid=" + bid +
                ", content='" + content + '\'' +
                '}';
    }
}
