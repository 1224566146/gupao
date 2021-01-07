package com.gupaoedu.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.mall.goods.bean.SkuAttribute;

import java.util.List;

/**
 *
 */
public interface SkuAttributeService extends IService<SkuAttribute> {

    /**
     * 根据分类ID查询属性集合
     */
    List<SkuAttribute> queryList(Integer id);
}
