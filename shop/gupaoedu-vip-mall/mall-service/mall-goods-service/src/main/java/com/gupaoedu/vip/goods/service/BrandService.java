package com.gupaoedu.vip.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Brand;

import java.util.List;

/**
 *
 */
public interface BrandService extends IService<Brand> {

    /**
     * 功能描述:条件查询
     * @param brand
     * @return List<Brand>
     */
    List<Brand> queryList(Brand brand);

    /**
     * 功能描述:条件分页查询
     * @param brand
     * @param currentPage 当前页码
     * @param size 每页显示条数
     * @return Page<Brand>
     */
    Page<Brand> queryPageList(Brand brand,Long currentPage,Long size);


    /**
     * 根据分类ID查询品牌集合
     */
    List<Brand> queryByCategoryId(Integer id);
}
