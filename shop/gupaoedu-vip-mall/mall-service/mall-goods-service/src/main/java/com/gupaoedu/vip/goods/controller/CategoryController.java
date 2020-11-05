package com.gupaoedu.vip.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.goods.service.CategoryService;
import com.gupaoedu.vip.mall.goods.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据分类父ID查询子分类
     */
    @GetMapping(value = "/parent/{id}")
    public RespResult<List<Category>> findByParentId(@PathVariable("id")Integer id){
        return RespResult.ok(categoryService.findByParentId(id));
    }

}
