package com.gupaoedu.mall.goods.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

//MyBatisPlus表映射注解
@TableName(value = "category_attr")
public class CategoryAttr {

    @TableField
    private Integer categoryId;

    @TableField
    private Integer attrId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }
}
