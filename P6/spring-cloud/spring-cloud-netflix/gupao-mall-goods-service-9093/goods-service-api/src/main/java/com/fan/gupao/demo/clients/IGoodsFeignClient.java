package com.fan.gupao.demo.clients;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.dto.ItemStockDto;
import com.fan.gupao.demo.vo.ItemDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
@FeignClient(value = "goods-service")
public interface IGoodsFeignClient {


    /**
     * 功能描述: 锁定并扣减库存
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/7/27 17:10
     */
    @PutMapping(value = "/items/stock",consumes = MediaType.APPLICATION_JSON_VALUE)
    R decreaseStock(@RequestBody List<ItemStockDto> itemStockDtos);


    /**
     * 功能描述: 根据商品id查询商品列表
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/7/27 17:10
     */
    @GetMapping("/items/{ids}")
    R<List<ItemDetailVo>> getItemsByIds(@PathVariable("ids")List<Long> ids);

}
