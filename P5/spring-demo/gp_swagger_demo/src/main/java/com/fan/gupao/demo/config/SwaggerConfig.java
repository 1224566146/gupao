package com.fan.gupao.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 樊高风
 * @date 2020/8/25
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket getDocket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 设置别名的时候一定不要使用中文
                .groupName("A")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fan.gupao.demo.controller"))
                .build();
    }

    @Bean
    public Docket getDocket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 设置别名的时候一定不要使用中文
                .groupName("B")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fan.gupao.demo.controller2"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Swagger测试"
                , "测试"
                , "1.0"
                , "123"
                , new Contact("樊高风", "1233", "456")
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0");
    }

}
