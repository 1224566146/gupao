package com.gupaoedu.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.mall.goods.bean.AdItems;
import com.gupaoedu.mall.goods.bean.Sku;
import com.gupaoedu.mall.goods.mapper.AdItemsMapper;
import com.gupaoedu.mall.goods.mapper.SkuMapper;
import com.gupaoedu.mall.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Autowired
    private AdItemsMapper adItemsMapper;

    @Autowired
    private SkuMapper skuMapper;

    /**
     * 根据推广产品分类ID查询Sku列表
     */
    @Cacheable(cacheNames = "ad-items-skus",key = "#id")
    @Override
    public List<Sku> typeSkuItems(Integer id) {
        List<Sku> skus = getSkus(id);
        return skus;
    }

    /**
     * 清理缓存
     */
    @CacheEvict(cacheNames = "ad-items-skus",key = "#id")
    @Override
    public void delTypeSkuItems(Integer id) {

    }

    @CachePut(cacheNames = "ad-items-skus",key = "#id")
    @Override
    public void updateTypeSkuItems(Integer id) {
       getSkus(id);
    }

    private List<Sku> getSkus(Integer id){
        // 查询所有分类下的推广
        QueryWrapper<AdItems> adItemsQueryWrapper = new QueryWrapper<>();
        adItemsQueryWrapper.eq("type", id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);

        // 获取所有SkuId
        List<String> skuIds = adItems.stream().map(adItem -> adItem.getSkuId()).collect(Collectors.toList());
        // 批量查询Sku
        List<Sku> skus = skuMapper.selectBatchIds(skuIds);
        return skus;
    }
}
