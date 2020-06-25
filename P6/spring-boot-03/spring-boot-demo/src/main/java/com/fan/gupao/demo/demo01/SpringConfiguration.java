package com.fan.gupao.demo.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
@Configuration
public class SpringConfiguration {

    /**
     * 功能描述: 在某个环境下不装载
     *  或者不满足某个条件的时候,不装载
     *  或者,如果已经装载过了,就不重复装载
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/6/25 16:21
     */
    @Conditional(GpCondition.class)
    @Bean
    public DemoService demoService(){
        return new DemoService();
    }
}
