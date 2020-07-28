package com.fan.gupao.demo.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
@Data
public class ItemDetailVo {

    private Long id;

    private String title;

    private BigDecimal price;

    private Integer num;

    private String image;

    private Long cid;



}
