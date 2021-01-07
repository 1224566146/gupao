package com.gupaoedu.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gupaoedu.mall.goods.bean.Brand;
import com.gupaoedu.mall.goods.service.BrandService;
import com.gupaoedu.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RequestMapping(value = "/brand")
@RestController
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 增加品牌
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand){
        brandService.save(brand);
        return RespResult.ok();
    }

    @PutMapping
    public RespResult update(@RequestBody Brand brand){
        // 修改品牌
        brandService.updateById(brand);
        return RespResult.ok();
    }

    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable(value = "id")Integer id){
        brandService.removeById(id);
        return RespResult.ok();
    }


    @GetMapping(value = "/list")
    public RespResult<List<Brand>> list(@RequestBody(required = false) Brand brand){
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }


    @GetMapping(value = "/list/{page}/{size}")
    public RespResult<Page<Brand>> list(@PathVariable(value = "page")Long currentPage,
                                        @PathVariable(value = "size")Long size,
                                        @RequestBody(required = false)Brand brand){
        // 分页查询
        Page<Brand> page = brandService.queryPageList(currentPage, size, brand);
        return RespResult.ok(page);
    }

    /**
     * 根据分类ID查询品牌
     */
    @GetMapping(value = "/category/{id}")
    public RespResult<List<Brand>> categoryBrands(@PathVariable(value = "id")Integer id){
        List<Brand> brands = brandService.queryByCategoryId(id);
        return RespResult.ok(brands);
    }

}
