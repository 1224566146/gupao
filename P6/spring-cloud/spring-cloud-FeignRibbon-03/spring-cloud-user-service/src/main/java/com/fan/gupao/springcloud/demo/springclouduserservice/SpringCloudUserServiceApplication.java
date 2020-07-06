package com.fan.gupao.springcloud.demo.springclouduserservice;

import com.fan.gupao.springcloud.demo.demo02.EnableGpRegistrara;
import com.fan.gupao.springcloud.demo.demo02.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;


@EnableGpRegistrara
@EnableFeignClients(basePackages = "com.fan.gupao.demo.clients")
@SpringBootApplication
public class SpringCloudUserServiceApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringCloudUserServiceApplication.class, args);

        System.out.println(context.getBean(HelloService.class));
    }

}
