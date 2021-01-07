package com.gupaoedu.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.mall.goods.bean.Category;

import java.util.List;

/**
 *
 */
public interface CategoryService extends IService<Category> {

    /**
     * 根据父ID查询子分类
     */
    List<Category> queryByParentId(Integer id);

}
