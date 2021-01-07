package com.gupaoedu.mall.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.mall.goods.bean.Brand;

import java.util.List;

/**
 *
 */
public interface BrandService extends IService<Brand> {


    /**
     * 条件查询
     */
    List<Brand> queryList(Brand brand);

    /**
     * 分页条件查询
     */
    Page<Brand> queryPageList(Long currentPage,Long size,Brand brand);

    /**
     * 根据分类ID查询品牌
     */
    List<Brand> queryByCategoryId(Integer id);

}
