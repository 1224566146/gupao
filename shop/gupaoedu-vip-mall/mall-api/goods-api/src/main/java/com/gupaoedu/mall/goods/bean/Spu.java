package com.gupaoedu.mall.goods.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


//MyBatisPlus表映射注解
@TableName(value = "spu")
public class Spu {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    private String name;
    private String intro;
    private Integer brandId;
    private Integer categoryOneId;
    private Integer categoryTwoId;
    private Integer categoryThreeId;
    private String images;
    private String afterSalesService;
    private String content;
    private String attributeList;
    private Integer isMarketable;
    private Integer isDelete;
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategoryOneId() {
        return categoryOneId;
    }

    public void setCategoryOneId(Integer categoryOneId) {
        this.categoryOneId = categoryOneId;
    }

    public Integer getCategoryTwoId() {
        return categoryTwoId;
    }

    public void setCategoryTwoId(Integer categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }

    public Integer getCategoryThreeId() {
        return categoryThreeId;
    }

    public void setCategoryThreeId(Integer categoryThreeId) {
        this.categoryThreeId = categoryThreeId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAfterSalesService() {
        return afterSalesService;
    }

    public void setAfterSalesService(String afterSalesService) {
        this.afterSalesService = afterSalesService;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(String attributeList) {
        this.attributeList = attributeList;
    }

    public Integer getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(Integer isMarketable) {
        this.isMarketable = isMarketable;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
