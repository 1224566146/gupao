package com.fan.gupao.demo.userserviceprovider.hystrix;

import java.lang.annotation.*;

/**
 * @author 樊高风
 * @date 2020/7/20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GpHystrixCommand {

    /**
     * 功能描述: 默认超时时间
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/7/20 9:17
     */
    int timeout() default 1000;


    /**
     * 功能描述: 回退方法
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/7/20 9:17
     */
    String fallback() default "";

}
