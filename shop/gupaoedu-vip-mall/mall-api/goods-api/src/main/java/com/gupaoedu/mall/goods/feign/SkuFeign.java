package com.gupaoedu.mall.goods.feign;

import com.gupaoedu.mall.goods.bean.Sku;
import com.gupaoedu.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 *
 */
@FeignClient(value = "mall-goods-service")
public interface SkuFeign {

    /**
     * 指定分类下的推广产品列表
     */
    @GetMapping(value = "/sku/aditems/type/{id}")
    public List<Sku> typeItems(@PathVariable(value = "id")Integer id);


    /**
     * 删除指定分类下的推广产品列表
     */
    @DeleteMapping(value = "/sku/aditems/type/{id}")
    public RespResult deleteTypeItems(@PathVariable(value = "id")Integer id);


    /**
     * 更新指定分类下的推广产品列表
     */
    @PutMapping(value = "/sku/aditems/type/{id}")
    public RespResult updateTypeItems(@PathVariable(value = "id")Integer id);

}
