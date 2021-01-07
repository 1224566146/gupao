package com.gupaoedu.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.mall.goods.bean.Sku;

import java.util.List;

/**
 *
 */
public interface SkuService extends IService<Sku> {


    /**
     * 根据推广产品分类ID查询Sku列表
     */
    List<Sku> typeSkuItems(Integer id);


    /**
     * 清理分类ID下的推广产品
     */
    void delTypeSkuItems(Integer id);

    /**
     * 更新分类ID下的推广产品缓存
     */
    void updateTypeSkuItems(Integer id);

}
