package com.fan.gupao.mybatis.v1.mapper;



/**
 * @Author: qingshan
 */
//@Entity(Blog.class)
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
//    @Select("select * from blog where bid = ? ")
    public Blog selectBlogById(Integer bid);

}
