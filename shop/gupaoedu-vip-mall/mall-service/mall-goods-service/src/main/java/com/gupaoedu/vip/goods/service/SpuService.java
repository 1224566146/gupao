package com.gupaoedu.vip.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Product;
import com.gupaoedu.vip.mall.goods.model.Spu;

/**
 *
 */
public interface SpuService extends IService<Spu> {


    /**
     * 产品保存
     */
    void saveProduct(Product product);

}
