package com.gupaoedu.vip.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gupaoedu.vip.mall.goods.model.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface BrandMapper extends BaseMapper<Brand> {


    /**
     * 1、根据分类ID查询品牌ID集合
     */
    @Select("SELECT brand_id FROM category_brand WHERE category_id = #{id}")
    List<Integer> queryBrandIds(Integer id);

}
