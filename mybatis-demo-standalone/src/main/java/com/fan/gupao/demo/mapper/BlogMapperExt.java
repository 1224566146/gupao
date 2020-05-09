package com.fan.gupao.demo.mapper;

import com.fan.gupao.demo.domain.Blog;

/**
 * @Description: 扩展类继承了MBG生成的接口和Statement
 * @Author: 樊高风
 * @Date: 15:29 2020/5/8
 */
public interface BlogMapperExt extends BlogMapper {

    /**
     * 根据名称查询文章
     * @param name
     * @return
     */
    Blog selectBlogByName(String name);
}
