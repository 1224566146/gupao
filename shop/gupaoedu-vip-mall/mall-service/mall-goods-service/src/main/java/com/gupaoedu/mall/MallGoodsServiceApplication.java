package com.gupaoedu.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.gupaoedu.mall.goods.mapper")
public class MallGoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGoodsServiceApplication.class, args);
    }

}
