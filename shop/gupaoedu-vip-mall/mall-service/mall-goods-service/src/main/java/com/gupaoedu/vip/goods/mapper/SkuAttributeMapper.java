package com.gupaoedu.vip.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gupaoedu.vip.mall.goods.model.SkuAttribute;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface SkuAttributeMapper extends BaseMapper<SkuAttribute> {

    /**
     * 1、根据分类ID查询属性ID集合
     * 2、根据属性ID集合查询属性集合
     */
    @Select("select * from sku_attribute where id in (select attr_id from category_attr where category_id=#{id})")
    List<SkuAttribute> queryByCategoryId(Integer id);

}
