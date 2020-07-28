package com.fan.gupao.demo.goodsserviceprovider.feign;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.clients.IGoodsFeignClient;
import com.fan.gupao.demo.dto.ItemStockDto;
import com.fan.gupao.demo.goodsserviceprovider.converter.ItemConverter;
import com.fan.gupao.demo.goodsserviceprovider.domain.ItemStockDo;
import com.fan.gupao.demo.goodsserviceprovider.mapper.entitys.TbItem;
import com.fan.gupao.demo.goodsserviceprovider.service.IItemService;
import com.fan.gupao.demo.vo.ItemDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/28
 */
@Slf4j
@RestController
public class GoodsFeignClient implements IGoodsFeignClient {

    @Autowired
    IItemService iItemService;

    @Autowired
    ItemConverter itemConverter;

    @Override
    public R decreaseStock(List<ItemStockDto> itemStockDtos) {
        log.info("begin GoodsFeignClient.decreaseStock:"+itemStockDtos);
        List<ItemStockDo> itemStockDos = itemConverter.itemStockDo2DoList(itemStockDtos);
        boolean rs = iItemService.decreaseStock(itemStockDos);
        return new R.Builder<>().buildOk();
    }

    @Override
    public R<List<ItemDetailVo>> getItemsByIds(List<Long> ids) {
        log.info("begin GoodsFeignClient.getItemsByIds:"+ids);
        List<TbItem> itemList = iItemService.findItemByIds(ids);
        List<ItemDetailVo> itemDetailVos = itemConverter.itemDetails2VoList(itemList);
        return new R.Builder<List<ItemDetailVo>>().setData(itemDetailVos).buildOk();
    }
}
