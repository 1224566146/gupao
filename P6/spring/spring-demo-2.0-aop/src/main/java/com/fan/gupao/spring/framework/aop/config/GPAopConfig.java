package com.fan.gupao.spring.framework.aop.config;

import lombok.Data;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:55 2020/4/13
 */
@Data
public class GPAopConfig {

    private String poinCut;

    private String aspectClass;

    private String aspectBefore;

    private String aspectAfter;

    private String aspectAfterThrow;

    private String aspectAfterThrowingName;

}
