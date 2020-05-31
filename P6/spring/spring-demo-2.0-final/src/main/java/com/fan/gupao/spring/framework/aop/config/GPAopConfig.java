package com.fan.gupao.spring.framework.aop.config;

import lombok.Data;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 18:33 2020/4/27
 */
@Data
public class GPAopConfig {

    private String pointCut;

    private String aspectClass;

    private String aspectBefore;

    private String aspectAfter;

    private String aspectAfterThrow;

    private String aspectAfterThrowingName;

}
