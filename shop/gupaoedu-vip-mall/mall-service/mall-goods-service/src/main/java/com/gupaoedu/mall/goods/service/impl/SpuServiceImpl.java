package com.gupaoedu.mall.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.mall.goods.bean.*;
import com.gupaoedu.mall.goods.mapper.BrandMapper;
import com.gupaoedu.mall.goods.mapper.CategoryMapper;
import com.gupaoedu.mall.goods.mapper.SkuMapper;
import com.gupaoedu.mall.goods.mapper.SpuMapper;
import com.gupaoedu.mall.goods.service.SpuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 *
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {


    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 保存商品
     */
    @Override
    public void saveProduct(Product product) {

        // Spu
        Spu spu = product.getSpu();
        // 如果ID为空,则增加
        if(StringUtils.isEmpty(spu.getId())){
            // 上架
            spu.setIsMarketable(1);
            // 未删除
            spu.setIsDelete(0);
            // 状态
            spu.setStatus(1);
            // 添加
            spuMapper.insert(spu);
        }else{
            // ID 不为空,则修改
            spuMapper.updateById(spu);
            // 删除之前的sku记录
            skuMapper.delete(new QueryWrapper<Sku>().eq("spu_id", spu.getId()));
        }


        // 查询三级分类
        Category category = categoryMapper.selectById(spu.getCategoryThreeId());
        // 查询品牌
        Brand brand = brandMapper.selectById(spu.getBrandId());
        // 当前时间
        Date now = new Date();

        // 新增sku集合
        for (Sku sku : product.getSkus()) {
            // 设置名字
            String skuName = spu.getName();
            Map<String,String> attrMap = JSON.parseObject(sku.getSkuAttribute(), Map.class);
            for (Map.Entry<String, String> entry : attrMap.entrySet()) {
                skuName +="   "+entry.getValue();
            }
            sku.setName(skuName);
            // 设置图片
            sku.setImages(spu.getImages());
            //设置状态
            sku.setStatus(1);
            //设置类目ID
            sku.setCategoryId(spu.getCategoryThreeId());
            //设置类目名称
            sku.setCategoryName(category.getName());
            //设置品牌ID
            sku.setBrandId(brand.getId());
            //设置品牌名称
            sku.setBrandName(brand.getName());
            //设置Spuid
            sku.setSpuId(spu.getId());
            //时间
            sku.setCreateTime(now);
            sku.setUpdateTime(now);
            //增加
            skuMapper.insert(sku);
        }

    }
}
