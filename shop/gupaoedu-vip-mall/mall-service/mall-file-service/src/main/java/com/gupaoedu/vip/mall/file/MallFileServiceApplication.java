package com.gupaoedu.vip.mall.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MallFileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallFileServiceApplication.class, args);
    }

}
