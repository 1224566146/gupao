package com.gupaoedu.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gupaoedu.mall.goods.bean.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface BrandMapper extends BaseMapper<Brand> {


    /**
     * 根据分类ID查询品牌集合
     */
    @Select("select brand_id from category_brand where category_id=#{id}")
    List<Integer> queryBrandIds(Integer id);

}
