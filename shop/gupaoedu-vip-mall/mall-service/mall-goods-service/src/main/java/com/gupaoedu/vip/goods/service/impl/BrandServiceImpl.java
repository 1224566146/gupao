package com.gupaoedu.vip.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.goods.mapper.BrandMapper;
import com.gupaoedu.vip.goods.service.BrandService;
import com.gupaoedu.vip.mall.goods.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    /**
     * 功能描述:条件查询
     * @param brand
     * @return List<Brand>
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        // 条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        // 根据name查询品牌
        queryWrapper.like("name", brand.getName());

        // 根据initial查询
        queryWrapper.eq("initial", brand.getInitial());
        return brandMapper.selectList(queryWrapper);
    }

    /**
     * 功能描述:条件分页查询
     * @param brand
     * @param currentPage 当前页码
     * @param size 每页显示条数
     * @return Page<Brand>
     */
    @Override
    public Page<Brand> queryPageList(Brand brand, Long currentPage, Long size) {
        // 条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        // 根据name查询品牌
        queryWrapper.like("name", brand.getName());
        return brandMapper.selectPage(new Page<>(currentPage, size), queryWrapper);
    }

    /**
     * 根据分类ID查询品牌集合
     * @param id 分类ID
     *
     */
    @Override
    public List<Brand> queryByCategoryId(Integer id) {
        // 根据分类ID查询品牌ID集合
        List<Integer> brandIds = brandMapper.queryBrandIds(id);
        // 根据品牌ID集合查询品牌集合
        if(!CollectionUtils.isEmpty(brandIds)){
            return brandMapper.selectList(new QueryWrapper<Brand>().in("id", brandIds));
        }
        return null;
    }
}
