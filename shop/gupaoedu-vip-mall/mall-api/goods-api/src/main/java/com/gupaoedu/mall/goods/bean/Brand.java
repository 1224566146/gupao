package com.gupaoedu.mall.goods.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;


//MyBatisPlus表映射注解
@TableName(value = "brand")
public class Brand implements Serializable {
    //    品牌ID
    //    MyBatisPlus主键策略注解
    @TableId(type= IdType.AUTO)
    private Integer id;
    //    品牌名字
    private String name;
    //    品牌图片
    private String image;
    //    品牌首字母
    private String initial;
    //    品牌排序
    private Integer sort;

    //分类
    @TableField(exist = false)
    private List<Category> categories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
