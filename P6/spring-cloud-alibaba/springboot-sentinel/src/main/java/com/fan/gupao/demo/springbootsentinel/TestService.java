package com.fan.gupao.demo.springbootsentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author 樊高风
 * @date 2020/9/21
 */
@Service
public class TestService {

    @SentinelResource(value = "doTest",blockHandler ="blockHandler",fallback = "fallback")
    public String doTest(String name){
        return "hello"+name;
    }

    // 降级,限流触发的
    public String blockHandler(String name, BlockException e){
        return "被限流了";
    }

    // 熔断触发的
    public String fallback(String name){
        return "被降级了";
    }
}
