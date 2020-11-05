package com.gupaoedu.vip.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.goods.service.SpuService;
import com.gupaoedu.vip.mall.goods.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping(value = "/spu")
@CrossOrigin
public class SpuController {

    @Autowired
    private SpuService spuService;


    /**
     * 产品保存
     */
    @PostMapping(value = "/save")
    public RespResult save(@RequestBody Product product){
        spuService.saveProduct(product);
        return RespResult.ok();
    }

}
