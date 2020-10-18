package com.fan.gupao.demo.spring_oauth_resources_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringOauthResourcesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOauthResourcesServerApplication.class, args);
    }

}
