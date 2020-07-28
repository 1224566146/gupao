package com.fan.gupao.demo.goodsserviceprovider.converter;

import com.fan.gupao.demo.dto.ItemStockDto;
import com.fan.gupao.demo.goodsserviceprovider.domain.ItemStockDo;
import com.fan.gupao.demo.goodsserviceprovider.mapper.entitys.TbItem;
import com.fan.gupao.demo.vo.ItemDetailVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/28
 */
@Mapper(componentModel = "spring")
public interface ItemConverter {

    @Mappings({})
    ItemDetailVo tbItemDetail2Vo(TbItem tbItem);

    List<ItemDetailVo> itemDetails2VoList(List<TbItem> tbItemsList);

    @Mappings({})
    ItemStockDo itemStockDto2Do(ItemStockDto itemStockDto);

    List<ItemStockDo> itemStockDo2DoList(List<ItemStockDto> itemStockDtos);
}
