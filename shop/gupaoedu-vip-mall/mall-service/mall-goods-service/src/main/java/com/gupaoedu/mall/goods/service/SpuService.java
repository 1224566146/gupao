package com.gupaoedu.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.mall.goods.bean.Product;
import com.gupaoedu.mall.goods.bean.Spu;

/**
 *
 */
public interface SpuService extends IService<Spu> {

    /**
     * 保存商品
     */
    void saveProduct(Product product);
}
