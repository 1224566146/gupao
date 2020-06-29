package com.fan.gupao.demo.springbootdemo02;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
public class CustomerHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

    }
}
