package com.fan.gupao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:20 2020/5/7
 */
@Configuration
@ComponentScan("com.fan.gupao")
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter1(){
        return route(GET("/time"),req -> timeHandler.getTime(req))
                .andRoute(GET("/date"), timeHandler::getDate); //这种方式相对于上一行更加简洁
    }

    @Bean
    public RouterFunction<ServerResponse> timerRouter2(){
        return route(GET("/time"), timeHandler::getTime)
                .andRoute(GET("/date"), timeHandler::getDate)
                .andRoute(GET("/times"),timeHandler::sendTimePerSec); //增加这一行
    }
}
