package com.fan.gupao.demo.goodsserviceprovider.service;

import com.fan.gupao.demo.goodsserviceprovider.domain.ItemStockDo;
import com.fan.gupao.demo.goodsserviceprovider.mapper.entitys.TbItem;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
public interface IItemService {

    List<TbItem> findItemByIds(List<Long> ids);

    boolean decreaseStock(List<ItemStockDo> itemStockDos);

}
