package com.fan.gupao.demo.springbootdemo02;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
@Endpoint(id="customer")
public class CustomerMetricsIndicator {

    public Map<String,Object> time(){
        Map<String,Object> result = new HashMap<>();
        Date time = new Date();
        result.put("当前时间", time.toString());
        return result;
    }
}
