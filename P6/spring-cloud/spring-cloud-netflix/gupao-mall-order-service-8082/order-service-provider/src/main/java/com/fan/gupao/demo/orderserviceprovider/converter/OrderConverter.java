package com.fan.gupao.demo.orderserviceprovider.converter;

import com.fan.gupao.demo.dto.ItemStockDto;
import com.fan.gupao.demo.orderserviceprovider.controller.dto.ItemsDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/28
 */
@Mapper(componentModel = "spring")
public interface OrderConverter {

    ItemStockDto itemDtoStockDto(ItemsDto itemsDto);

    List<ItemStockDto> itemsDto2StockDtoList(List<ItemsDto> itemsDtos);

}
