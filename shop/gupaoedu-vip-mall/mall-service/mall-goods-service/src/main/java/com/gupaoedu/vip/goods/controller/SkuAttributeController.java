package com.gupaoedu.vip.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.goods.service.SkuAttributeService;
import com.gupaoedu.vip.mall.goods.model.SkuAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/skuAttribute")
@CrossOrigin
public class SkuAttributeController {

    @Autowired
    private SkuAttributeService skuAttributeService;


    /**
     * 根据分类ID查询属性集合
     */
    @GetMapping(value = "/category/{id}")
    public RespResult<List<SkuAttribute>> categorySkuAttributeList(@PathVariable(value = "id")Integer id){
        List<SkuAttribute> skuAttributes = skuAttributeService.queryList(id);
        return RespResult.ok(skuAttributes);
    }

}
