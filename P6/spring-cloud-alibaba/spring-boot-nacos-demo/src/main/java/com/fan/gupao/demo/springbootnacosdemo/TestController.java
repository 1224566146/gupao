package com.fan.gupao.demo.springbootnacosdemo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/27
 */
@NacosPropertySource(dataId = "spring-boot-nacos-demo",autoRefreshed = true)
@RestController
public class TestController {

    @NacosValue(value = "${info:defaul value}",autoRefreshed = true)
    private String info;

    @GetMapping("/get")
    public String get(){
        return info;
    }

}
