package com.gupaoedu.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.mall.goods.bean.Category;
import com.gupaoedu.mall.goods.mapper.CategoryMapper;
import com.gupaoedu.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父ID查询子分类
     */
    @Override
    public List<Category> queryByParentId(Integer id) {
        // 条件封装
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        return categoryMapper.selectList(queryWrapper);
    }
}
