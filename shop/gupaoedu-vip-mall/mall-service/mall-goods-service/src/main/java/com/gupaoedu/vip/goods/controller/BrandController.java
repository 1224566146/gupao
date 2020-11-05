package com.gupaoedu.vip.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.goods.service.BrandService;
import com.gupaoedu.vip.mall.goods.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;


    /**
     * 增加方法
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand){
        brandService.save(brand);
        return RespResult.ok();
    }

    /**
     * 修改方法
     */
    @PutMapping
    public RespResult update(@RequestBody Brand brand){
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /**
     * 删除方法
     */
    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable String id){
        brandService.removeById(id);
        return RespResult.ok();
    }


    /**
     * 条件查询
     */
    @GetMapping(value = "/search")
    public RespResult<List<Brand>> queryList(@RequestBody Brand brand){
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }

    /**
     * 条件分页查询
     */
    @GetMapping(value = "/search/{page}/{size}")
    public RespResult<Page<Brand>> queryPageList(@RequestBody Brand brand,
                                                 @PathVariable(value = "page")Long page,
                                                 @PathVariable(value = "size")Long size){
        Page<Brand> pageInfo = brandService.queryPageList(brand, page, size);
        return RespResult.ok(pageInfo);
    }


    /**
     * 根据分类ID查询品牌集合
     */
    @GetMapping(value = "/category/{pid}")
    public RespResult<List<Brand>> categoryBrands(@PathVariable(value = "pid")Integer pid){
        List<Brand> brands = brandService.queryByCategoryId(pid);
        return RespResult.ok(brands);
    }

}
