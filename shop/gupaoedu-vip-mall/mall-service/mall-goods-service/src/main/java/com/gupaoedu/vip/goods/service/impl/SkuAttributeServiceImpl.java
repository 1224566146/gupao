package com.gupaoedu.vip.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.goods.mapper.SkuAttributeMapper;
import com.gupaoedu.vip.goods.service.SkuAttributeService;
import com.gupaoedu.vip.mall.goods.model.SkuAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SkuAttributeServiceImpl extends ServiceImpl<SkuAttributeMapper, SkuAttribute> implements SkuAttributeService {

    @Autowired
    private SkuAttributeMapper skuAttributeMapper;

    /**
     * 根据分类ID查询属性集合
     */
    @Override
    public List<SkuAttribute> queryList(Integer id) {
        return skuAttributeMapper.queryByCategoryId(id);
    }
}
